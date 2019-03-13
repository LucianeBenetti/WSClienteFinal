package wslucianeclientefinal;

import VO.LocalEsp;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MenuLocalEsp {
    
    private static final int CADASTRAR_ESPECIALIDADE = 1;
    private static final int EXCLUIR_ESPECIALIDADE = 2;
    private static final int ATUALIZAR_ESPECIALIDADE = 3;
    private static final int EXIBIR_ESPECIALIDADE_POR_ID = 4;
    private static final int SAIR = 5;
    
    public void chamaMenuEspecialidade() {
        int opcao = -1;
        
        while (opcao !=5){
            try{
                String valorDigitado = JOptionPane.showInputDialog(criarMenuEspeciadidade());
                if(valorDigitado != null){
                    opcao = Integer.parseInt(valorDigitado);
                }else{
                    break;
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "O número digitado deve ser um inteiro entre 1 e 5");
            }
        switch(opcao){
            case 1:
                this.cadastrarEspecialidade();
                break;
            case 2:
		this.excluirEspecialidade();
		break;
            case 3:
		this.atualizarEspecialidade();
		break;
            case 4:
                this.consultarEspecialidadeID();
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
    private String criarMenuEspeciadidade() {
        String mensagem = "Menu Especialidade.";
        mensagem += "\n1 - Cadastrar Especialidade.";
        mensagem += "\n2 - Excluir Especialidade.";
        mensagem += "\n3 - Atualizar Especialidade.";   
        mensagem += "\n4 - Exibir Especialidade por ID.";
        mensagem += "\n5 - Sair.";
                
        return mensagem;
    }
    
    private void cadastrarEspecialidade() {
        LocalEsp especialidade = new LocalEsp();
             
        especialidade.setEspNome( JOptionPane.showInputDialog(null, "Digite o nome da especialidade."));
        especialidade.setEspInstituicao(JOptionPane.showInputDialog(null, "Digite a instituição."));
        
        MenuLocalEsp.inserirLocalEsp(especialidade.getEspNome(),especialidade.getEspInstituicao());
        JOptionPane.showMessageDialog(null,"Especialidade cadastrado com sucesso!");
         
      
        }
   
    private void excluirEspecialidade() {
        LocalEsp especialidade = new LocalEsp();
              
        especialidade.setEspecialidadeCod(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID da especialidade para excluir")));
        MenuLocalEsp.deleteLocalEsp((especialidade.getEspecialidadeCod()));
        JOptionPane.showMessageDialog(null,"Especialidade deleteada com sucesso!");
        
    }

    private void atualizarEspecialidade() {
        LocalEsp especialidade = new LocalEsp();
                
        especialidade.setEspecialidadeCod(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID da Especialidade para atualizar.")));
        if (MenuLocalEsp.existeRegistroPorIdLocalEsp(especialidade.getEspecialidadeCod())){
        
        especialidade.setEspNome(JOptionPane.showInputDialog(null, "Digite o nome da especialidade."));
        especialidade.setEspInstituicao(JOptionPane.showInputDialog(null, "Digite a instituição."));
       
        MenuLocalEsp.atualizarLocalEsp(especialidade.getEspNome(),especialidade.getEspInstituicao(),especialidade.getEspecialidadeCod());
           JOptionPane.showMessageDialog(null, "Especialidade atualizada com sucesso!");	
        }else{
           JOptionPane.showMessageDialog(null,"Especialidade não cadastrado. Tente novamente!");
        }
            
        }
       
      private void consultarEspecialidadeID() {
            LocalEsp especialidadeConsultada = new LocalEsp();
            especialidadeConsultada.setEspecialidadeCod(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Id da especialidade para consultar")));
          
            if(especialidadeConsultada != null) {
                MenuLocalEsp.consultarEspecialidadePorID(especialidadeConsultada.getEspecialidadeCod());
		JOptionPane.showMessageDialog(null, especialidadeConsultada);
            }else {
		JOptionPane.showMessageDialog(null,"Especialidade não encontrada. Tente novamente!");
            }
     }

    private static boolean atualizarLocalEsp(java.lang.String espNome, java.lang.String espInstituicao, int espCod) {
        dao.LocalEspDAO_Service service = new dao.LocalEspDAO_Service();
        dao.LocalEspDAO port = service.getLocalEspDAOPort();
        return port.atualizarLocalEsp(espNome, espInstituicao, espCod);
    }

    private static java.util.List<dao.LocalEsp> consultarEspecialidadePorID(int espCod) {
        dao.LocalEspDAO_Service service = new dao.LocalEspDAO_Service();
        dao.LocalEspDAO port = service.getLocalEspDAOPort();
        return port.consultarEspecialidadePorID(espCod);
    }

    private static boolean deleteLocalEsp(int espCod) {
        dao.LocalEspDAO_Service service = new dao.LocalEspDAO_Service();
        dao.LocalEspDAO port = service.getLocalEspDAOPort();
        return port.deleteLocalEsp(espCod);
    }

    private static boolean existeRegistroPorIdLocalEsp(int espCod) {
        dao.LocalEspDAO_Service service = new dao.LocalEspDAO_Service();
        dao.LocalEspDAO port = service.getLocalEspDAOPort();
        return port.existeRegistroPorIdLocalEsp(espCod);
    }

    private static int inserirLocalEsp(java.lang.String espNome, java.lang.String espInstituicao) {
        dao.LocalEspDAO_Service service = new dao.LocalEspDAO_Service();
        dao.LocalEspDAO port = service.getLocalEspDAOPort();
        return port.inserirLocalEsp(espNome, espInstituicao);
    }

   
  }
