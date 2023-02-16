package br.inatel.cdg.nasa.DAO;

import br.inatel.cdg.nasa.MODEL.Mapa;

import java.sql.SQLException;
import java.util.ArrayList;

public class MapaDAO extends ConnectionDAO
{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    // INSERIR UM MAPA
    public boolean inserirMapa(Mapa mapa)
    {
        connectToDB();
        String sql = "INSERT INTO mapa (idMapa, titulo, orientacoes, obstaculos) values(?,?,?,?)";
        try
        {
            pst = con.prepareStatement(sql);
            pst.setInt(1, mapa.getIdMapa());
            pst.setString(2, mapa.getTitulo());
            pst.setString(3, mapa.getOrientacoes());
            pst.setInt(4, mapa.getObstaculos());
            pst.execute();
            sucesso = true;
        }
        catch (SQLException exc)
        {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        }
        finally
        {
            try
            {
                con.close();
                pst.close();
            }
            catch (SQLException exc)
            {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    // ATUALIZAR MAPA
    public boolean atualizarMapa(int id, Mapa mapa)
    {
        connectToDB();
        String sql = "UPDATE mapa SET titulo=?, orientacoes=?, obstaculos=? where idMapa=?";

        try
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, mapa.getTitulo());
            pst.setString(2, mapa.getOrientacoes());
            pst.setInt(3, mapa.getObstaculos());
            pst.setInt(4, mapa.getIdMapa());
            pst.execute();
            sucesso = true;
        }
        catch (SQLException ex)
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        }
        finally
        {
            try
            {
                con.close();
                pst.close();
            }
            catch (SQLException exc)
            {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    // DELETAR MAPA
    public boolean deletarMapa(int id)
    {
        connectToDB();
        String sql = "DELETE FROM mapa where idMapa=?";

        try
        {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        }
        catch (SQLException ex)
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        }
        finally
        {
            try
            {
                con.close();
                pst.close();
            }
            catch (SQLException exc)
            {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    // MOSTRA INFO MAPA
    public ArrayList<Mapa> buscarMapaSemFiltro()
    {
        ArrayList<Mapa> listaDeMapa = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Mapa";
        try
        {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Mapas: ");

            while (rs.next())
            {
                Mapa mapaAux = new Mapa();
                mapaAux.setIdMapa(rs.getInt("IdMapa"));
                mapaAux.setTitulo(rs.getString("Titulo"));
                mapaAux.setObstaculos(rs.getInt("Obstaculos"));
                mapaAux.setOrientacoes(rs.getString("Orientacoes"));

                System.out.println("IdMapa: " + mapaAux.getIdMapa());
                System.out.println("Titulo: " + mapaAux.getTitulo());
                System.out.println("Orientacoes: " + mapaAux.getOrientacoes());
                System.out.println("Obstaculos: " + mapaAux.getObstaculos());
                System.out.println("--------------------------------");
                listaDeMapa.add(mapaAux);
            }
            sucesso = true;
        }
        catch(SQLException e)
        {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        }
        finally
        {
            try
            {
                con.close();
                st.close();
            }
            catch(SQLException e)
            {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return listaDeMapa;
    }

}



