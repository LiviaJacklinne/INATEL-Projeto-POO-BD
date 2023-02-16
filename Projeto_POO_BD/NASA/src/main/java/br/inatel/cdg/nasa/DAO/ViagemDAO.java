package br.inatel.cdg.nasa.DAO;

import br.inatel.cdg.nasa.MODEL.Viagem;

import java.sql.SQLException;
import java.util.ArrayList;

public class ViagemDAO extends ConnectionDAO
{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    // INSERIR VIAGEM
    public boolean inserirViagem(Viagem viagem)
    {
        connectToDB();
       String sql = "INSERT INTO viagem (Planeta_idPlaneta, Nave_idNave, distancia, Mapa_idMapa, idViagem) values(?,?,?,?,?)";
       //String sql = "INSERT INTO viagem (distancia, idViagem) values(?,?)";

        try
        {
            pst = con.prepareStatement(sql);
            pst.setInt(1, viagem.getPlaneta_idPlaneta());
            pst.setInt(2, viagem.getNave_idNave());
            pst.setFloat(3, viagem.getDistancia());
            pst.setInt(4, viagem.getMapa_idMapa());
            pst.setInt(5, viagem.getIdViagem());
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

    //  ATUALIZAR VIAGEM
    public boolean atualizarViagem(Viagem viagem)
    {
        connectToDB();
        String sql = "UPDATE viagem SET distancia = ? where idViagem=?";

        try
        {
            pst = con.prepareStatement(sql);
            pst.setFloat(1, viagem.getDistancia());
            pst.setInt(2, viagem.getIdViagem());
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

    // DELETAR VIAGEM
    public boolean deletarViagem(int id)
    {
        connectToDB();
        String sql = "DELETE FROM viagem where idViagem=?";

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

    // MOSTRA INFO VIAGEM
    public ArrayList<Viagem> buscarViagemSemFiltro()
    {
        ArrayList<Viagem> listaDeViagem = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Viagem";
        try
        {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Viagens ");
            while (rs.next())
            {
                Viagem viagemAux = new Viagem();
                viagemAux.setNave_idNave(rs.getInt("Nave_idNave"));
                viagemAux.setMapa_idMapa(rs.getInt("Mapa_idMapa"));
                viagemAux.setPlaneta_idPlaneta(rs.getInt("Planeta_idPlaneta"));
                viagemAux.setDistancia(rs.getFloat("Distancia"));
                viagemAux.setIdViagem(rs.getInt("idViagem"));

                System.out.println("Nave_idNave: " + viagemAux.getNave_idNave());
                System.out.println("Mapa_idMapa: " + viagemAux.getMapa_idMapa());
                System.out.println("Planeta_idPlaneta: " + viagemAux.getPlaneta_idPlaneta());
                System.out.println("Distancia: " + viagemAux.getDistancia());
                System.out.println("idViagem: " + viagemAux.getIdViagem());
                System.out.println("--------------------------------");
                listaDeViagem.add(viagemAux);
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
        return listaDeViagem;
    }
}