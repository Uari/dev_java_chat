package com.week3;

import java.awt.Component;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class ExTableAddBtn extends JFrame {

	private Object[] objColNms = new Object[] { "이름", "출근", "퇴근", "출근버튼", "퇴근버튼" };
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
		datas = new Object[][] { 
				{ "나신입", "08:59:00", "17:00:00", null, null },
				{ "나일등", "08:57:00", "17:00:00", null, null }, 
				{ "나초보", "08:55:00", "17:00:00", null, null } 
				};
		dtm = new DefaultTableModel(datas, objColNms);
		jtable = new JTable(dtm);
		jsp = new JScrollPane(jtable);

		jtable.getColumnModel().getColumn(3).setCellRenderer(new TableCell("출근버튼"));
		jtable.getColumnModel().getColumn(3).setCellEditor(new TableCell("출근버튼"));
		jtable.getColumnModel().getColumn(4).setCellRenderer(new TableCell("퇴근버튼"));
		jtable.getColumnModel().getColumn(4).setCellEditor(new TableCell("퇴근버튼"));

		jf.add(jsp);
		jf.setVisible(true);
	}
	// **추가 시간생성
	private String getTimeStr() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);

		return (hour < 10 ? "0" + hour : "" + hour) + ":" +
				(min < 10 ? "0" + min : "" + min)  +	":" +
				(sec < 10 ? "0" + sec : "" + sec) ;
	}

	@SuppressWarnings("rawtypes")
	public void JTableEventRow() {
		int row = jtable.getSelectedRow();
		if (row == -1)
			return;
		
		// **추가 데이터 수정 
		int col = jtable.getSelectedColumn();
		datas[row][col - 2] = getTimeStr();
		DefaultTableModel model = (DefaultTableModel) jtable.getModel();
		model.setDataVector(datas, objColNms);

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
			jtable.getColumnModel().getColumn(3).setCellRenderer(new TableCell("출근버튼"));
			jtable.getColumnModel().getColumn(3).setCellEditor(new TableCell("출근버튼"));
			jtable.getColumnModel().getColumn(4).setCellRenderer(new TableCell("퇴근버튼"));
			jtable.getColumnModel().getColumn(4).setCellEditor(new TableCell("퇴근버튼"));

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

		public TableCell(String str) {
			jb = new JButton(str);
			jb.addActionListener(e -> {// 람다식
				JTableEventRow();
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