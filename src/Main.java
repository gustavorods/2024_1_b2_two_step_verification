import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.Locale;

public class Main extends JFrame {
    // Objetos
    JLabel tituloLabel, dataLabel, horaLabel;
    JTextField campoCod;
    JButton btnMaiusculo, btnMinusculo, btnEntrar, btnReenviarCod;
    Calendar data, hora;

    public Main() {
        // Configurações da janela
            super("Verificação de 2 etapas");
            Container tela = getContentPane();
            setLayout(null);
            setSize(600, 400);
            setResizable(false);
        // Criando os elementos
            // Label
            tituloLabel = new JLabel("Insira o código:");
            dataLabel = new JLabel("Data: ");
            horaLabel = new JLabel("Hora: ");

            // Button
            btnMaiusculo = new JButton("Tudo maiúsculo");
            btnMinusculo = new JButton("Tudo minúsculo");
            btnEntrar = new JButton("Entrar");
            btnReenviarCod = new JButton("Reenviar código");

            // Data
            data = Calendar.getInstance();
            int dia = data.get(Calendar.DAY_OF_MONTH);
            int mes = data.get(Calendar.MONTH) + 1;
            int ano = data.get(Calendar.YEAR);
            dataLabel.setText("Data: " + dia + "/" + mes + "/" + ano);

            // Hora
            hora = Calendar.getInstance();
            atualizarHora();
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    atualizarHora();
                }
            });
            timer.start();

            // JtextField
            campoCod = new JTextField();

        // Posicionar
            tituloLabel.setBounds(250, 15, 150, 20);
            campoCod.setBounds(220, 100, 150, 25);
            btnMaiusculo.setBounds(20, 100, 130, 25);
            btnMinusculo.setBounds(420, 100, 130, 25);
            btnEntrar.setBounds(170, 145, 100, 20);
            btnReenviarCod.setBounds(290, 145, 150, 20);
            dataLabel.setBounds(20, 320, 100, 20);
            horaLabel.setBounds(420, 320, 100, 20);

        // Dicas
            btnEntrar.setToolTipText("Botão de entrar");
            btnReenviarCod.setToolTipText("Botão para reenviar o código");
            btnMaiusculo.setToolTipText("Deixar texto tudo maiúsculo");
            btnMinusculo.setToolTipText("Deixar texto tudo minúsculo");

        // Funções
            btnMaiusculo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    campoCod.setText(campoCod.getText().toUpperCase());
                }
            });

            btnMinusculo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    campoCod.setText(campoCod.getText().toLowerCase());
                }
            });

            btnEntrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int opcao = JOptionPane.showConfirmDialog(null,
                            "O código esta certo?",
                            "Verificação", JOptionPane.YES_NO_OPTION);

                    if (opcao == 0) {
                        JOptionPane.showMessageDialog(null,"Bem-Vindo");
                    }
                }
            });

            btnReenviarCod.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Aviso", "O código só pode ser reenviado 3 vezes", JOptionPane.ERROR_MESSAGE);
                }
            });


        // Adicionando na tela
            tela.add(tituloLabel);
            tela.add(campoCod);
            tela.add(btnMaiusculo);
            tela.add(btnMinusculo);
            tela.add(btnEntrar);
            tela.add(btnReenviarCod);
            tela.add(dataLabel);
            tela.add(horaLabel);


        setVisible(true);
    }


    // Método para atualizar a hora atual
    private void atualizarHora() {
        hora = Calendar.getInstance();
        int hh = hora.get(Calendar.HOUR_OF_DAY);
        int mm = hora.get(Calendar.MINUTE);
        int ss = hora.get(Calendar.SECOND);
        horaLabel.setText("Hora: " + hh + ":" + mm + ":" + ss);
    }


    public static void main(String[] args) {
        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
