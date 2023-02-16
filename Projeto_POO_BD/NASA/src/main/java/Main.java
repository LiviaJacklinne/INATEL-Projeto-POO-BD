import br.inatel.cdg.nasa.DAO.*;
import br.inatel.cdg.nasa.MODEL.*;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Entrada de dados + Interação com o usuario
        Scanner entrada = new Scanner (System.in);

        // Variaveis auxiliares para entrada de dados
        int x, y, aux;

        // Instancias
        PlanetaDAO AddPlaneta = new PlanetaDAO();
        Planeta planeta1 = new Planeta();
        PlanetaDAO deletarPlaneta = new PlanetaDAO();

        MapaDAO AddMapa = new MapaDAO();
        Mapa mapa1 = new Mapa();

        NaveDAO AddNave = new NaveDAO();
        Nave nave1 = new Nave();

        PassageiroDAO AddPassageiro = new PassageiroDAO();
        Passageiro passageiro1 = new Passageiro();

        ViagemDAO AddViagem = new ViagemDAO();
        Viagem viagem1 = new Viagem();

        // Loop CRUD
        do
        {
            // Menu incial
            System.out.println("Digite o que deseja: ");
            System.out.println("1 - Inserir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Deletar");
            System.out.println("0 - Sair\n");

            x = entrada.nextInt();

            // INSERIR, ALTERAR, DELETAR, SAIR
            switch (x)
            {
                // INSERIR DADOS
                case 1:
                    {
                        // MENU DAS TABELAS
                        System.out.println("O que voce deseja criar?");

                        System.out.println("1 - Planeta");
                        System.out.println("2 - Mapa");
                        System.out.println("3 - Nave");
                        System.out.println("4 - Passageiro");
                        System.out.println("5 - Viagem\n");
                        aux = entrada.nextInt();

                        // CRIANDO UM PLANETA
                        if (aux == 1)
                        {
                            System.out.println("Entre com o id do planeta: ");
                            planeta1.setIdPlaneta(entrada.nextInt());
                            entrada.nextLine();
                            System.out.println("Entre com o nome do planeta: ");
                            planeta1.setNome(entrada.nextLine());
                            System.out.println("O planeta e habitavel? (true or false) ");
                            planeta1.setHabitavel(entrada.nextBoolean());
                            entrada.nextLine();

                            AddPlaneta.inserirPlaneta(planeta1);
                        }

                        // Criando um mapa
                        else if (aux == 2)
                        {
                            System.out.println("Entre com o id do mapa:");
                            mapa1.setIdMapa(entrada.nextInt());
                            entrada.nextLine();
                            System.out.println("Entre com o titulo do mapa:");
                            mapa1.setTitulo(entrada.nextLine());
                            System.out.println("Entre com as orientacoes:");
                            mapa1.setOrientacoes(entrada.nextLine());
                            System.out.println("Entre com o numero de ostaculos:");
                            mapa1.setObstaculos(entrada.nextInt());

                            AddMapa.inserirMapa(mapa1);
                        }

                        // Criando uma Nave
                        else if (aux == 3)
                        {
                            System.out.println("Entre com o id da Nave:");
                            nave1.setIdNave(entrada.nextInt());
                            entrada.nextLine();
                            System.out.println("Entre com o nome da nave: ");
                            nave1.setNome(entrada.nextLine());

                            AddNave.inserirNave(nave1);
                        }

                        // Criando um passageiro
                        else if (aux == 4)
                        {
                            System.out.println("Entre com o id do passageiro:");
                            passageiro1.setIdPassageiro(entrada.nextInt());
                            entrada.nextLine();
                            System.out.println("Entre com o nome do passageiro: ");
                            passageiro1.setNome(entrada.nextLine());
                            System.out.println("Entre com a idade do passageiro: ");
                            passageiro1.setIdade(entrada.nextInt());
                            entrada.nextLine();
                            System.out.println("Entre com o sexo do passageiro: ");
                            passageiro1.setSexo(entrada.nextLine());
                            passageiro1.setPassageiro_has_nave(passageiro1.getIdPassageiro());

                            AddPassageiro.inserirPassageiro(passageiro1);
                        }

                        // CRIANDO UMA VIAGEM
                        else if (aux == 5)
                        {
                            System.out.println("Entre com o ID da viagem: ");
                            viagem1.setIdViagem(entrada.nextInt());
                            System.out.println("Digite a distancia da viagem: ");
                            viagem1.setDistancia(entrada.nextFloat());
                            System.out.println("Entre com o Planeta_idPlaneta: ");
                            viagem1.setPlaneta_idPlaneta(entrada.nextInt());
                            System.out.println("Entre com o Mapa_idMapa: ");
                            viagem1.setMapa_idMapa(entrada.nextInt());
                            System.out.println("Entre com o Nave_idNave: ");
                            viagem1.setNave_idNave(entrada.nextInt());

                            AddViagem.inserirViagem(viagem1);
                        }

                        else
                            System.out.println("Opção invalida\n");

                    }break;

                // ALTERANDO DADOS
                case 2:
                 if(x == 2)
                 {
                     // MENU DAS TABELAS
                     System.out.println("Qual tabela deseja alterar?");
                     System.out.println("1 - Planeta");
                     System.out.println("2 - Mapa");
                     System.out.println("3 - Nave");
                     System.out.println("4 - Passageiro");
                     System.out.println("5 - Viagem\n");
                     aux = entrada.nextInt();

                     // ALTERANDO UM PLANETA
                     if (aux == 1)
                     {
                         // FUNCAO MOSTRA INFO
                         AddPlaneta.buscarPlanetaSemFiltro();
                         System.out.println("----------------------------");

                         System.out.println("Entre com o id do planeta: ");
                         planeta1.setIdPlaneta(entrada.nextInt());
                         entrada.nextLine();
                         System.out.println("Entre com o nome do planeta: ");
                         planeta1.setNome(entrada.nextLine());
                         System.out.println("O planeta e habitavel? (true or false) ");
                         planeta1.setHabitavel(entrada.nextBoolean());
                         entrada.nextLine();

                         AddPlaneta.atualizarPlaneta(planeta1.getIdPlaneta(), planeta1);

                     }

                     // ALTERANDO UM MAPA
                     else if (aux == 2)
                     {
                         // FUNÇÃO MOSTRA INFO
                         AddMapa.buscarMapaSemFiltro();
                         System.out.println("----------------------------");

                         System.out.println("Entre com o id do mapa:");
                         mapa1.setIdMapa(entrada.nextInt());
                         entrada.nextLine();
                         System.out.println("Entre com o titulo do mapa:");
                         mapa1.setTitulo(entrada.nextLine());
                         System.out.println("Entre com as orientacoes:");
                         mapa1.setOrientacoes(entrada.nextLine());
                         System.out.println("Entre com o numero de ostaculos:");
                         mapa1.setObstaculos(entrada.nextInt());

                         AddMapa.atualizarMapa(mapa1.getIdMapa(), mapa1);

                     }

                     // ALTERANDO UMA NAVE
                     else if (aux == 3)
                     {
                         // FUNCAO MOSTRA INFO
                         AddNave.buscarNaveSemFiltro();
                         System.out.println("----------------------------");

                         System.out.println("Entre com o id da Nave:");
                         nave1.setIdNave(entrada.nextInt());
                         entrada.nextLine();
                         System.out.println("Entre com o nome da nave: ");
                         nave1.setNome(entrada.nextLine());

                         AddNave.atualizarNave(nave1.getIdNave(), nave1);
                     }

                     // ALTERANDO UM PASSAGEIRO
                     else if (aux == 4)
                     {
                         // FUNCAO MOSTRA INFO
                         AddPassageiro.buscarPassageiroSemFiltro();
                         System.out.println("----------------------------");

                         System.out.println("Entre com o id do passageiro:");
                         passageiro1.setIdPassageiro(entrada.nextInt());
                         entrada.nextLine();
                         System.out.println("Entre com o nome do passageiro: ");
                         passageiro1.setNome(entrada.nextLine());
                         System.out.println("Entre com a idade do passageiro: ");
                         passageiro1.setIdade(entrada.nextInt());
                         entrada.nextLine();
                         System.out.println("Entre com o sexo do passageiro: ");
                         passageiro1.setSexo(entrada.nextLine());
                         passageiro1.setPassageiro_has_nave(passageiro1.getIdPassageiro());

                         AddPassageiro.atualizarPassageiro(passageiro1.getIdPassageiro(), passageiro1);
                     }

                     // ALTERANDO UMA VIAGEM
                     else if (aux == 5)
                     {
                         // MOSTRA INFO
                         AddViagem.buscarViagemSemFiltro();

                         System.out.println("Entre com o ID da viagem: ");
                         viagem1.setIdViagem(entrada.nextInt());
                         System.out.println("Digite a distancia da viagem: ");
                         viagem1.setDistancia(entrada.nextFloat());

                         AddViagem.atualizarViagem(viagem1);
                     }

                 }break;

                // DELETAR
                case 3:

                    System.out.println("O que deseja deletar?\n");

                    System.out.println("1 - Planeta");
                    System.out.println("2 - Mapa");
                    System.out.println("3 - Nave");
                    System.out.println("4 - Passageiro");
                    System.out.println("5 - Viagem\n");
                    aux = entrada.nextInt();


                    //DELETANDO PLANETA
                    if(aux == 1)
                    {
                        // mostra info
                        AddPlaneta.buscarPlanetaSemFiltro();
                        System.out.println("----------------------------");

                        System.out.println("Digite o ID do Planeta que deseja apagar");
                        AddPlaneta.deletarPlaneta(entrada.nextInt());
                    }

                    // DELETANDO MAPA
                    else if(aux == 2)
                    {
                        // MOSTRA INFO
                        AddMapa.buscarMapaSemFiltro();
                        System.out.println("----------------------------");

                        System.out.println("Digite o ID do Mapa que deseja apagar");
                        AddMapa.deletarMapa(entrada.nextInt());
                    }

                    // DELETANDO NAVE
                    else if(aux == 3)
                    {
                        // MOSTRA INFO
                        AddNave.buscarNaveSemFiltro();
                        System.out.println("----------------------------");

                        System.out.println("Digite o ID da Nave que deseja apagar");
                        AddNave.deletarNave(entrada.nextInt());
                    }

                    // DELETANDO PASSAGEIRO
                    else if(aux == 4)
                    {
                        // MOSTRA INFO
                        AddPassageiro.buscarPassageiroSemFiltro();
                        System.out.println("----------------------------");

                        System.out.println("Digite o ID do Passageiro que deseja apagar");
                        AddPassageiro.deletarPassageiro(entrada.nextInt());
                    }

                    // DELETANDO VIAGEM
                    else if (aux == 5)
                    {
                        // MOSTRA INFO
                        AddViagem.buscarViagemSemFiltro();
                        System.out.println("----------------------------");

                        System.out.println("Digite o ID da Viagem que deseja apagar: ");
                        AddViagem.deletarViagem(entrada.nextInt());
                    }

                    break;

                default:
                    System.out.println("Valor invalido");
                    break;
            }

            System.out.println("-----------------------------------");
            System.out.println("Se deseja sair digite 0\n" + "Se deseja continuar digite 1");
            y = entrada.nextInt();
            System.out.println("-----------------------------------");

        } while (!(y == 0));

        // Fechando entrada de dados
        entrada.close();

    }
}

