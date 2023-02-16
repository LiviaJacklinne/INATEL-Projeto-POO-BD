package br.inatel.cdg.nasa.DAO;

import br.inatel.cdg.nasa.MODEL.Passageiro;
import java.sql.SQLException;
import java.util.ArrayList;

public class PassageiroDAO extends ConnectionDAO
{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    // INSERIR PASSAGEIRO
    public boolean inserirPassageiro(Passageiro passageiro)
    {
        connectToDB();

        // OBS: nave_IdNave (chave estrangeira), não inclusa
        String sql = "INSERT INTO passageiro (idPassageiro, nome, idade, sexo,passageiro_has_nave) values(?,?,?,?,?)";
        try
        {
            pst = con.prepareStatement(sql);
            pst.setInt(1,passageiro.getIdPassageiro());
            pst.setString(2,passageiro.getNome());
            pst.setInt(3,passageiro.getIdade());
            pst.setString(4,passageiro.getSexo());
            pst.setInt(5, passageiro.getPassageiro_has_nave());
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

    // ATUALIZAR PASSAGEIRO
    public boolean atualizarPassageiro(int id, Passageiro passageiro)
    {
        connectToDB();
        String sql = "UPDATE Passageiro SET nome=?, idade=?, sexo=? where idPassageiro=?";

        try
        {
            pst = con.prepareStatement(sql);
            pst.setString(1,passageiro.getNome());
            pst.setInt(2,passageiro.getIdade());
            pst.setString(3,passageiro.getSexo());
           // pst.setInt(4, passageiro.getPassageiro_has_nave());
            pst.setInt(4,passageiro.getIdPassageiro());
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

    // DELETAR PASSAGEIRO
    public boolean deletarPassageiro(int id)
    {
        connectToDB();
        String sql = "DELETE FROM passageiro where idPassageiro=?";

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

    // BUSCAR PASSAGEIRO
    public ArrayList<Passageiro> buscarPassageiroSemFiltro()
    {
        ArrayList<Passageiro> listaDePassageiro = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Passageiro";
        try
        {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Passageiros: ");
            while (rs.next())
            {
                Passageiro passageiroAux = new Passageiro();
                passageiroAux.setIdPassageiro(rs.getInt("IdPassageiro"));
                passageiroAux.setNome(rs.getString("Nome"));
                passageiroAux.setIdade(rs.getInt("Idade"));
                passageiroAux.setSexo(rs.getString("Sexo"));
                passageiroAux.setPassageiro_has_nave(rs.getInt("Passageiro_has_nave"));

                System.out.println("IdPassageiro: " + passageiroAux.getIdPassageiro());
                System.out.println("Nome: " + passageiroAux.getNome());
                System.out.println("Idade: " + passageiroAux.getIdade());
                System.out.println("Sexo: " + passageiroAux.getSexo());
                System.out.println("Passageiro_has_nave: " + passageiroAux.getPassageiro_has_nave());
                System.out.println("--------------------------------");
                listaDePassageiro.add(passageiroAux);
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
        return listaDePassageiro;
    }

}
