package com.ifpb.ads.bdnc.jedis;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 02/08/2017 , 08:28:05
 */
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela<E> extends AbstractTableModel {
    
    private ArrayList linhas=null;
    private String[] colunas=null;

    public ModeloTabela(ArrayList lin,String[] col) {
        setLinhas(lin);
        setColunas(col);
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    @Override
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    @Override
    public Object getValueAt(int numLin, int numCol) {
        Object [] linha=(Object[])getLinhas().get(numLin);
        return linha[numCol];
    }

    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
}
