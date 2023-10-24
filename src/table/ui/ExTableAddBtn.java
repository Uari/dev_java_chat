package table.ui;

import java.awt.Component;
import java.util.Vector;
 
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
 
@SuppressWarnings("serial")
public class ExTableAddBtn extends JFrame {
    
	//이름, 출근, 퇴근, 출근버튼(출근시간), 퇴근버튼(최근시간)
	//출근버튼 눌럿을때 현재 시간으로 바뀌게
	
    private Object[] objColNms = new Object[] { "사원명", "출근시간", "퇴근시간", "출근버튼", "퇴근버튼" };
    private Object[][] datas = null;
 
    public static void main(String[] args) {
        new ExTableAddBtn();
    }
 
    private JFrame jf;
    private DefaultTableModel dtm;
    private JTable jtable;
    private JScrollPane jsp;
 
    public ExTableAddBtn() {
        jf = new JFrame("JTable Add Delete Button");
        jf.setLocationRelativeTo(null);
        jf.setSize(500, 300);
        datas = new Object[][]{ 
        		{ "나신입", "data2", "data3",null,null }, 
        		{ "나일등", "data5", "data6",null,null }, 
        		{ "나초보", "data8", "data9",null,null } 
        		};
 
        dtm = new DefaultTableModel(
        		datas,
                objColNms);
        jtable = new JTable(dtm);
        jsp = new JScrollPane(jtable);
 
        jtable.getColumnModel().getColumn(3).setCellRenderer(new TableCell());
        jtable.getColumnModel().getColumn(3).setCellEditor(new TableCell());
        jtable.getColumnModel().getColumn(4).setCellRenderer(new TableCell());
        jtable.getColumnModel().getColumn(4).setCellEditor(new TableCell());
        
        jf.add(jsp);
        jf.setVisible(true);
    }
 
    @SuppressWarnings("rawtypes")
    public void JTableRemoveRow() {
        int row = jtable.getSelectedRow();
        if (row == -1)
            return;
 
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.removeRow(row);
 
        int rowCnt = jtable.getRowCount();
 
        if (rowCnt > 0) {
            Vector vector = model.getDataVector();
            Object[][] objData = new Object[vector.size()][((Vector) vector.get(0)).size()];
            for (int i = 0; i < vector.size(); i++) {
                Vector vec = (Vector) vector.get(i);
                for (int j = 0; j < vec.size(); j++) {
                    objData[i][j] = vec.get(j);
                }
            }
 
            DefaultTableModel clonModel = new DefaultTableModel(objData, objColNms);
            JTable clonTable = new JTable(clonModel);
 
            jf.getContentPane().removeAll();
 
            jtable = clonTable;
            jsp = new JScrollPane(jtable);
            jtable.getColumnModel().getColumn(3).setCellRenderer(new TableCell());
            jtable.getColumnModel().getColumn(3).setCellEditor(new TableCell());
            jtable.getColumnModel().getColumn(4).setCellRenderer(new TableCell());
            jtable.getColumnModel().getColumn(4).setCellEditor(new TableCell());
 
            jf.add(jsp);
            jf.revalidate();
            jf.repaint();
        } else {
            DefaultTableModel clonModel = new DefaultTableModel(null, objColNms);
            JTable clonTable = new JTable(clonModel);
 
            jf.getContentPane().removeAll();
 
            jtable = clonTable;
            jsp = new JScrollPane(jtable);
 
            jf.add(jsp);
            jf.revalidate();
            jf.repaint();
        }
    } // end public void JTableRemoveRow()
 
    class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;
 
        public TableCell() {
            jb = new JButton("출근버튼");
            jb.addActionListener(e -> {
                JTableRemoveRow();
            });
        }
 
        @Override
        public Object getCellEditorValue() {
            return null;
        }
 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            return jb;
        }
 
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            return jb;
        }
    } // end class TableCell extends AbstractCellEditor implements TableCellEditor,
        // TableCellRenderer
}