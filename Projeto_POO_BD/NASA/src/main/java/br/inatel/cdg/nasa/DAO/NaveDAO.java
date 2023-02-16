package br.inatel.cdg.nasa.DAO;

import br.inatel.cdg.nasa.MODEL.Nave;

import java.sql.SQLException;
import java.util.ArrayList;

public class NaveDAO extends ConnectionDAO
{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    // INSERIR NAVE
    public boolean inserirNave(Nave nave)
    {
        connectToDB();
        String sql = "INSERT INTO nave (idNave, nome) values(?,?)";
        try
        {
            pst = con.prepareStatement(sql);
            pst.setInt(1, nave.getIdNave());
            pst.setString(2, nave.getNome());
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

    // ATUALIZAR NAVE
    public boolean atualizarNave(int id, Nave nave)
    {
        connectToDB();
        String sql = "UPDATE Nave SET nome=? where idNave=?";

        try
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, nave.getNome());
            pst.setInt(2, nave.getIdNave());
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

    // METODO DE DELETAR NAVE
    public boolean deletarNave(int id)
    {
        connectToDB();
        String sql = "DELETE FROM nave where idNave=?";

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

    // FUNÇÃO MOSTRA INFO
    public ArrayList<Nave> buscarNaveSemFiltro()
    {
        ArrayList<Nave> listaDeNave = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Nave";
        try
        {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Naves: ");
            while (rs.next())
            {
                Nave naveAux = new Nave();
                naveAux.setIdNave(rs.getInt("IdNave"));
                naveAux.setNome(rs.getString("Nome"));

                System.out.println("IdNave: " + naveAux.getIdNave());
                System.out.println("Nome: " + naveAux.getNome());
                System.out.println("--------------------------------");
                listaDeNave.add(naveAux);
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

        return listaDeNave;
    }
}
