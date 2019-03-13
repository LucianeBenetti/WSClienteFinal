package wslucianeclientefinal;

import VO.EspecializacaoVO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MenuEspecializacao {

    private static final int CADASTRAR_ESPECIALIZACAO = 1;
    private static final int EXCLUIR_ESPECIALIZACAO = 2;
    private static final int ATUALIZAR_ESPECIALIZACAO = 3;
    private static final int EXIBIR_ESPECIALIZACAO_POR_ID = 4;
    private static final int SAIR = 5;
    
    public void chamaMenuEspecializacao() {
        int opcao = -1;
        
        while (opcao !=5){
            try{
                String valorDigitado = JOptionPane.showInputDialog(criarMenuEspecializacao());
                if(valorDigitado != null){
                    opcao = Integer.parseInt(valorDigitado);
                }else{
                    break;
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "O número digitado deve ser um inteiro entre 1 e 5.");
            }
            switch(opcao){
                case 1:
                this.cadastrarEspecializacao();
                break;
            case 2:
		this.excluirEspecializacao();
		break;
            case 3:
		this.atualizaEspecializacao();
		break;
            case 4:
                try {
                    this.consultarEspecializacaoID();
                } catch (SQLException ex) {
                    Logger.getLogger(MenuEspecializacao.class.getName()).log(Level.SEVERE, null, ex);
               }
            	break;
            case 5: 
                int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza?");
                    if(resposta == 0){
                        JOptionPane.showMessageDialog(null, "Você foi desconectado");
                        break;
                    }
            default:
                JOptionPane.showMessageDialog(null, "Opção Inválida!");
            }  
        }
    }
    
    private String criarMenuEspecializacao() {
       String mensagem = "Menu Especialização";
       mensagem += "\n1 - Cadastrar Especialização.";
       mensagem += "\n2 - Excluir Especialização.";
       mensagem += "\n3 - Atualizar Especialização.";   
       mensagem += "\n4 - Exibir Especialização por ID.";
       mensagem += "\n5 - Sair.";
       return mensagem;
    }
     private void cadastrarEspecializacao() {
       EspecializacaoVO especializacao =new EspecializacaoVO();
               
        especializacao.setEspCod(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID da especialidade.")));
        especializacao.setMedCod(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do médico.")));
        especializacao.setEspAnoEspecializacao(JOptionPane.showInputDialog(null, "Digite o ano da Especialização"));
            
        MenuEspecializacao.inserirEspecializacao(especializacao.getEspCod(), especializacao.getMedCod(), especializacao.getEspAnoEspecializacao());
        JOptionPane.showMessageDialog(null,"Especializacao cadastrada com sucesso!");
       
    }

    private void excluirEspecializacao() {
        EspecializacaoVO especializacao = new EspecializacaoVO();

        especializacao.setEspeCod(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID da especializacao para excluir")));
        if(MenuEspecializacao.deleteEspecializacao(especializacao.getEspeCod())){
        JOptionPane.showMessageDialog(null,"Especializacao deleteada com sucesso!");

        }else{
          JOptionPane.showMessageDialog(null, "ID não existe. Não foi possível excluir a especializacao.");  
        }
    }

    private void atualizaEspecializacao() {
        EspecializacaoVO especializacao = new EspecializacaoVO();
                
        especializacao.setEspeCod(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID da Especialização para atualizar.")));
        if (MenuEspecializacao.existeRegistroPorIdEspecializacao(especializacao.getEspeCod())){
   
            especializacao.setEspCod(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID da especialidade.")));
            especializacao.setMedCod(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do médico.")));
            especializacao.setEspAnoEspecializacao(JOptionPane.showInputDialog(null, "Digite o ano da especialização."));
    
            MenuEspecializacao.atualizarEspecializacao(especializacao.getEspCod(), especializacao.getMedCod(), especializacao.getEspAnoEspecializacao(), especializacao.getEspeCod());
            JOptionPane.showMessageDialog(null, "Especializacao atualizada com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Especializacao não existe para atualizar!");
        }
    }

      private void consultarEspecializacaoID() throws SQLException {
        EspecializacaoVO especializacao = new EspecializacaoVO();
          
       especializacao.setEspeCod(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Id da especializacao para consultar")));
        
        if (especializacao != null){
           MenuEspecializacao.consultarEspecializacaoPorID(especializacao.getEspeCod());

            JOptionPane.showMessageDialog(null, especializacao);
        }else {
            JOptionPane.showMessageDialog(null,"Especializacao não encontrada. Tente novamente!");
        }
    }

    private static boolean atualizarEspecializacao(int espCod, int medCod, java.lang.String espAnoEspecializacao, int espeCod) {
        dao.EspecializacaoDAO_Service service = new dao.EspecializacaoDAO_Service();
        dao.EspecializacaoDAO port = service.getEspecializacaoDAOPort();
        return port.atualizarEspecializacao(espCod, medCod, espAnoEspecializacao, espeCod);
    }

    private static java.util.List<dao.EspecializacaoVO> consultarEspecializacaoPorID(int espeCod) {
        dao.EspecializacaoDAO_Service service = new dao.EspecializacaoDAO_Service();
        dao.EspecializacaoDAO port = service.getEspecializacaoDAOPort();
        return port.consultarEspecializacaoPorID(espeCod);
    }

    private static boolean deleteEspecializacao(int espeCod) {
        dao.EspecializacaoDAO_Service service = new dao.EspecializacaoDAO_Service();
        dao.EspecializacaoDAO port = service.getEspecializacaoDAOPort();
        return port.deleteEspecializacao(espeCod);
    }

    private static boolean existeRegistroPorIdEspecializacao(int espeCod) {
        dao.EspecializacaoDAO_Service service = new dao.EspecializacaoDAO_Service();
        dao.EspecializacaoDAO port = service.getEspecializacaoDAOPort();
        return port.existeRegistroPorIdEspecializacao(espeCod);
    }

    private static int inserirEspecializacao(int espCod, int medCod, java.lang.String espAnoEspecializacao) {
        dao.EspecializacaoDAO_Service service = new dao.EspecializacaoDAO_Service();
        dao.EspecializacaoDAO port = service.getEspecializacaoDAOPort();
        return port.inserirEspecializacao(espCod, medCod, espAnoEspecializacao);
    }

   
}
