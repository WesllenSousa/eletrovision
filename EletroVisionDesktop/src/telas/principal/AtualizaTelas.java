
package telas.principal;

import recursos.instancias.InstanciasTelas;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class AtualizaTelas {
    
    public static void geralLocalizacaoGps() {
        if(InstanciasTelas.getGeralLocalizacaoGps() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getGeralLocalizacaoGps().atualizarTela();
                }
            });
        }
    }
    
    public static void geralCenarios() {
        if(InstanciasTelas.getGeralCenario() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getGeralCenario().atualizarTela();
                }
            });
        }
    }
    
    public static void geralMapaDispositivos() {
        if(InstanciasTelas.getGeralMapaDispositivos() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getGeralMapaDispositivos().atualizarTela();
                }
            });
        } 
    }
    
    public static void geralVisualizarCameras() {
        if(InstanciasTelas.getGeralVisualizarCameras() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getGeralVisualizarCameras().atualizarTela();
                }
            });
        }
    }
    
    public static void geralAgendarTarefas() {
        if(InstanciasTelas.getGeralAgendarTarefas() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getGeralAgendarTarefas().atualizarTela();
                }
            });
        }
    }
    
    public static void ferramentasEditarImagens() {
        if(InstanciasTelas.getFerramentasEditarImagens() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getFerramentasEditarImagens().atualizarTela();
                }
            });
        }
    }
    
    public static void cadastrarArea() {
        if(InstanciasTelas.getCadastrarArea() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getCadastrarArea().atualizarTela();
                }
            });
        }
    }
    
    public static void cadastrarCamera() {
        if(InstanciasTelas.getCadastrarCamera() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getCadastrarCamera().atualizarTela();
                }
            });
        }
    }
    
    public static void cadastrarModuloAcionamento() {
        if(InstanciasTelas.getCadastrarModuloAcionamento() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getCadastrarModuloAcionamento().atualizarTela();
                }
            });
        }
    }
    
    public static void cadastrarDispositivoEletrico() {
        if(InstanciasTelas.getCadastrarDispositivoEletrico() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getCadastrarDispositivoEletrico().atualizarTela();
                }
            });
        }
    }
    
    public static void pesquisarDispositivoEletrico() {
        if(InstanciasTelas.getPesquisarDispositivoEletrico() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getPesquisarDispositivoEletrico().atualizarTela();
                }
            });
        }
    }
    
    public static void pesquisarModuloAcionamento() {
        if(InstanciasTelas.getPesquisarModuloAcionamento() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getPesquisarModuloAcionamento().atualizarTela();
                }
            });
        }
    }
    
    public static void pesquisarCamera() {
        if(InstanciasTelas.getPesquisarCamera() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getPesquisarCamera().atualizarTela();
                }
            });
        }
    }
    
    public static void pesquisarMarca() {
        if(InstanciasTelas.getPesquisarMarca() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getPesquisarMarca().atualizarTela();
                }
            });
        }
    }
    
    public static void pesquisarArea() {
        if(InstanciasTelas.getPesquisarArea() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getPesquisarArea().atualizarTela();
                }
            });
        }
    }
    
    public static void pesquisarUsuario() {
        if(InstanciasTelas.getPesquisarUsuario() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getPesquisarUsuario().atualizarTela();
                }
            });
        }
    }
    
    public static void pesquisarPredio() {
        if(InstanciasTelas.getPesquisarPredio() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getPesquisarPredio().atualizarTela();
                }
            });
        }
    }
    
    public static void pesquisarPessoas() {
        if(InstanciasTelas.getPesquisarPessoa() != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    InstanciasTelas.getPesquisarPessoa().atualizarTela();
                }
            });
        }
    }
    
}
