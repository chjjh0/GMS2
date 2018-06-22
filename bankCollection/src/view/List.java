package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class List extends JFrame {
	private static final long serialVersionUID = 1L;
	JLabel label, id, name, phone, address, company;
	JTextField fid, fname, fphone, faddress, fcompany, search;
	JButton add, delete, update, clear, all, sbutton;
	String items[] = { "이름", "주소", "회사" };
	JComboBox combo;
	JPanel bottompanel, leftpanel, center, pid, pname, pphone, padd, pcom;

	JScrollPane sp;
	Vector outer, title, noresult, msg; // noresult :검색결과없을때 테이블때문에
	JTable table;
	DefaultTableModel model;
	public List() {
		makeGui(); //화면구성
		model.setDataVector(outer, title);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public void makeGui() {

		label = new JLabel("Address Book", JLabel.CENTER);
		id = new JLabel("   I D :  ", JLabel.CENTER);

		fid = new JTextField(15);
		pid = new JPanel();
		pid.add(id);
		pid.add(fid);

		name = new JLabel("이름 : ");
		fname = new JTextField(15);
		pname = new JPanel();
		pname.add(name);
		pname.add(fname);

		phone = new JLabel("전화 : ");
		fphone = new JTextField(15);
		pphone = new JPanel();
		pphone.add(phone);
		pphone.add(fphone);

		address = new JLabel("주소 : ");
		faddress = new JTextField(15);
		padd = new JPanel();
		padd.add(address);
		padd.add(faddress);

		company = new JLabel("회사 : ");
		fcompany = new JTextField(15);
		pcom = new JPanel();
		pcom.add(company);
		pcom.add(fcompany);

		leftpanel = new JPanel();
		leftpanel.setLayout(new GridLayout(5, 1));
		leftpanel.add(pid);
		leftpanel.add(pname);
		leftpanel.add(pphone);
		leftpanel.add(padd);
		leftpanel.add(pcom);

		add = new JButton("추가");
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		delete = new JButton("삭제");
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		update = new JButton("수정");
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		combo = new JComboBox(items);

		search = new JTextField(15);
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		sbutton = new JButton("검색");
		sbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		clear = new JButton("지우기");
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		all = new JButton("전체보기");
		all.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		bottompanel = new JPanel();
		bottompanel.add(add);
		bottompanel.add(delete);
		bottompanel.add(update);
		bottompanel.add(combo);
		bottompanel.add(search);
		bottompanel.add(sbutton);
		bottompanel.add(clear);
		bottompanel.add(all);

		title = new Vector();
		outer = new Vector();
		noresult = new Vector();
		msg = new Vector();

		title.add("ID");
		title.add("Name");
		title.add("Phone");
		title.add("Address");
		title.add("Company");

		noresult.add("실행 결과");

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent w) {

				super.windowClosing(w);
			}
		});

		Container c = getContentPane();

		// DefaultTableModel 생성
		model = new DefaultTableModel();

		// model 사용해서 JTable 생성
		table = new JTable(model);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				// 클릭한 행의 인덱스 알아내기-->JTable의 메소드
				int index = table.getSelectedRow();

				// 인덱스 이용해서 out안의 작은 벡터 in 꺼내기
				Vector msg = (Vector) outer.get(index);

				// in 안에 들어 있는 번호,이름,주소 알아내서 텍스트 필드에 넣어주기
				String id = (String) msg.get(0);
				String name = (String) msg.get(1);
				String phone = (String) msg.get(2);
				String address = (String) msg.get(2);
				String company = (String) msg.get(2);

				fid.setText(id);
				fname.setText(name);
				fphone.setText(phone);
				faddress.setText(address);
				fcompany.setText(company);

				// 번호가 들어가는 텍스트 필드는 편집 불가 상태로 변경
				fid.setEditable(false);
			}
		});

		sp = new JScrollPane(table);

		center = new JPanel();
		center.add(leftpanel);
		center.add(sp);

		c.add(label, "North");
		c.add(center, "Center");
		c.add(bottompanel, "South");
	}
}
