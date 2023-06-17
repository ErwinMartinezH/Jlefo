package HerramientasGLC;

import HerramientasGLC.FuncionGrama.GLC;
import vista.V_panelGLC;

public class C_gramatica {//esta clase controla la gramatica libre de contexto
    public V_panelGLC PanelGLC;
    private GLC parse = null;

    public C_gramatica(V_panelGLC panelGLC) {
        this.PanelGLC = PanelGLC;

    }

}
