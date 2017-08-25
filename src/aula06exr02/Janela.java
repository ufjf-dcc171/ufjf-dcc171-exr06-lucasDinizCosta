package aula06exr02;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Janela extends JFrame {

    /**
     * Exercício 2) Construa uma aplicação gráfica que simule um jogo
     * pedra-papel-tesoura. Solicite: Uma das opções entre pedra, papel e
     * tesoura; Acrescente um botão para realizar o cálculo. A jogada da
     * “máquina” de ser realizada pelo java.util.Random (As chances não precisam
     * ser simétricas). Exiba um placar final após 7 rodadas.
     */
    private final JLabel escritoTitulo = new JLabel("Jo Ken Po");
    private final JLabel escritoDicas = new JLabel("<HTML>Dicas: Pedra ganha de Tesoura<br>Papel ganha de Pedra <br>Tesoura ganha de Papel</HTML>");
    private final JLabel escritoEnunciado = new JLabel("Selecione um dos três objetos: ");
    private final JRadioButton pedra = new JRadioButton("Pedra");       ///Opcao 1
    private final JRadioButton papel = new JRadioButton("Papel");       ///Opcao 2
    private final JRadioButton tesoura = new JRadioButton("Tesoura");   ///Opcao 3
    private final JButton pronto = new JButton("Pronto");
    private int rodadas = 1;                ///Jogo se encerra na 8ª Rodada, ou seja, após 7 rodadas
    private int vitorias = 0;
    private int derrotas = 0;
    private int empates = 0;
    private int opcao = 0;
    private final Random randomico = new Random();             //Responsável por atribuir um valor randomico
    private final JLabel resultado = new JLabel("Resultado:     ");
    private final JLabel escritoRodadas = new JLabel("Rodadas: " + rodadas);
    private final JLabel escritoVitorias = new JLabel("Vitorias: " + vitorias);
    private final JLabel escritoDerrotas = new JLabel("Derrotas: " + derrotas);
    private final JLabel escritoEmpates = new JLabel("Empates: " + empates);
   
    public Janela() throws HeadlessException {
        super("Exercicio 2 - Jo Ken Po");
        setLayout(new FlowLayout());
        //System.out.println(randomico.nextInt(3)+1);         //Valor randomico entre 1 e 3
        add(escritoTitulo);
        add(escritoDicas);
        add(escritoEnunciado);
        add(pedra);
        add(papel);
        add(tesoura);
        add(pronto);
        add(resultado);
        add(escritoRodadas);
        add(escritoVitorias);
        add(escritoDerrotas);
        add(escritoEmpates);
        ButtonGroup grupo = new ButtonGroup();                //Grupo responsável por permitir clicar em somente em um JRadioButton, regula todo mundo
        grupo.add(pedra);
        grupo.add(papel);
        grupo.add(tesoura);
        pedra.addItemListener(new controle());
        papel.addItemListener(new controle());
        tesoura.addItemListener(new controle());
        pronto.addActionListener(new controle());
    }

    private class controle implements ActionListener, ItemListener {
        
                
        public controle() {
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(pedra.isSelected()){
                System.out.println("Pedra");
                opcao = 1;
                System.out.println("1");
            } else if(papel.isSelected()){
                System.out.println("Papel");
                opcao = 2;
            } else if(tesoura.isSelected()){
                System.out.println("Tesoura");
                opcao = 3;
            }
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(rodadas < 7){
                if(opcao > 0){
                    int escolhaAdversario = randomico.nextInt(3)+1;         //1 - pedra 2 - papel 3 - tesoura
                    switch(escolhaAdversario){
                        case 1:     //Pedra
                            if(opcao == 1){     //Empate
                                JOptionPane.showMessageDialog(null, "Empate: \n Player: Pedra \n Adversário: Pedra", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                empates++;
                                escritoEmpates.setText("Empates: "+ empates);
                            }
                            else{
                                if(opcao == 2){ //Vitoria do player, papel > pedra
                                    JOptionPane.showMessageDialog(null, "Vitoria: \n Player: Papel \n Adversário: Pedra", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                    vitorias++;
                                    escritoVitorias.setText("Vitorias: " + vitorias);
                                }
                                else{           //Derrota do player, tesoura < pedra
                                    JOptionPane.showMessageDialog(null, "Derrota: \n Player: Tesoura \n Adversário: Pedra", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                    derrotas++;
                                    escritoDerrotas.setText("Derrotas: " + derrotas);
                                }
                            }
                            break;
                        case 2:     //Papel
                            if(opcao == 2){     //Empate
                                JOptionPane.showMessageDialog(null, "Empate: \n Player: Papel \n Adversário: Papel", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                empates++;
                                escritoEmpates.setText("Empates: " + empates);
                            }
                            else{
                                if(opcao == 3){ //Vitoria do player, tesoura > papel
                                    JOptionPane.showMessageDialog(null, "Vitoria: \n Player: Tesoura \n Adversário: Papel", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                    vitorias++;
                                    escritoVitorias.setText("Vitorias: " + vitorias);
                                }
                                else{           //Derrota do player, papel < pedra
                                    JOptionPane.showMessageDialog(null, "Derrota: \n Player: Pedra \n Adversário: Papel", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                    derrotas++;
                                    escritoDerrotas.setText("Derrotas: " + derrotas);
                                }
                            }
                            break;
                        case 3:     //Tesoura
                            if(opcao == 3){     //Empate
                                JOptionPane.showMessageDialog(null, "Empate: \n Player: Tesoura \n Adversário: Tesoura", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                empates++;
                                escritoEmpates.setText("Empates: " + empates);
                            }
                            else{
                                if(opcao == 2){ //Vitoria do player, tesoura > papel
                                    JOptionPane.showMessageDialog(null, "Vitoria: \n Player: Tesoura \n Adversário: Papel", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                    vitorias++;
                                    escritoVitorias.setText("Vitorias: " + vitorias);
                                }
                                else{           //Derrota do player, tesoura < pedra
                                    JOptionPane.showMessageDialog(null, "Derrota: \n Player: Tesoura \n Adversário: Pedra", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                                    derrotas++;
                                    escritoDerrotas.setText("Derrotas: " + derrotas);
                                }
                            }
                            break;
                        default:
                        {
                            JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA, ERRO.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                        }
                    }
                    rodadas++;
                    escritoRodadas.setText(rodadas+"");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Selecione um dos elementos","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Dentre 7 rodadas o status foi: Player: "+vitorias+"  Computador: "+derrotas,"Placar Final",JOptionPane.INFORMATION_MESSAGE);
                System.exit(1);
            }
        }
    }



}
