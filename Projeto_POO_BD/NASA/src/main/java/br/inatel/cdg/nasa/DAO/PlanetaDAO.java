package br.inatel.cdg.nasa.DAO;

import br.inatel.cdg.nasa.MODEL.Nave;
import br.inatel.cdg.nasa.MODEL.Passageiro;
import br.inatel.cdg.nasa.MODEL.Planeta;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlanetaDAO extends ConnectionDAO
{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    // INSERIR PLANETA
    public boolean inserirPlaneta(Planeta planeta)
    {
        connectToDB();

        // OBS: planeta_has_estrela (chave estrangeira), não inclusa
        String sql = "INSERT INTO planeta (idPlaneta, nome, habitavel) values(?,?,?)";
        try
        {
            pst = con.prepareStatement(sql);
            pst.setInt(1,planeta.getIdPlaneta());
            pst.setString(2,planeta.getNome());
            pst.setBoolean(3,planeta.isHabitavel());
            //pst.setInt(4, planeta.getPlaneta_has_estrela());
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

    // ATUALIZAR PLANETA
    public boolean atualizarPlaneta(int id, Planeta planeta)
    {
        connectToDB();
        String sql = "UPDATE Planeta SET nome=?, habitavel=? where idPlaneta=?";

        try
        {
            pst = con.prepareStatement(sql);
            pst.setString(1,planeta.getNome());
            pst.setBoolean(2,planeta.isHabitavel());
            pst.setInt(3,planeta.getIdPlaneta());
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

    // DELETAR PLANETA
    public boolean deletarPlaneta(int id)
    {
        connectToDB();
        String sql = "DELETE FROM planeta where idPlaneta=?";

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
    public ArrayList<Planeta> buscarPlanetaSemFiltro()
    {
        ArrayList<Planeta> listaDePlaneta = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Planeta";
        try
        {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Planetas: ");
            while (rs.next())
            {
                Planeta planetaAux = new Planeta();
                planetaAux.setIdPlaneta(rs.getInt("IdPlaneta"));
                planetaAux.setNome(rs.getString("Nome"));
                planetaAux.setHabitavel(rs.getBoolean("Habitavel"));

                System.out.println("IdPlaneta: " + planetaAux.getIdPlaneta());
                System.out.println("Nome: " + planetaAux.getNome());
                System.out.println("Habitavel: " + planetaAux.isHabitavel());
                System.out.println("--------------------------------");
                listaDePlaneta.add(planetaAux);
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

        return listaDePlaneta;
    }

}

