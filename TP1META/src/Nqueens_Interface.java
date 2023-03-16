import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Nqueens_Interface {

    private JFrame frame;
    private JPanel chessBoardPanel;
    private int n;
    private JList list;
    private JTextField textField;
    private JTextField txtNombreDeNoeuds;
    private JTextField txtNombreDeNoeuds_1;
    private JTextField txtTempsDexcution;
    private JTextField txtNombreDeSolutions;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Nqueens_Interface window = new Nqueens_Interface();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Nqueens_Interface() {
        n = 4; // Default chessboard size
        initialize();
        createChessBoard();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1068, 694);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("selectionnez une m\u00E9thode de recherche ");
        lblNewLabel.setForeground(Color.DARK_GRAY);
        lblNewLabel.setToolTipText("");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(660, 92, 362, 78);
        frame.getContentPane().add(lblNewLabel);

        chessBoardPanel = new JPanel();
        chessBoardPanel.setBounds(51, 10, 315, 315);
        chessBoardPanel.setLayout(new GridLayout(n, n));
        frame.getContentPane().add(chessBoardPanel);
        
        JButton btnRun = new JButton("Run");
        btnRun.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnRun.setForeground(SystemColor.scrollbar);
        btnRun.setBackground(SystemColor.textInactiveText);
        btnRun.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnRun.setBounds(786, 451, 125, 43);
        frame.getContentPane().add(btnRun);
        
        list = new JList();
        list.setSelectedIndices(new int[] {3});
        list.setToolTipText("");
        list.setVisibleRowCount(3);
        list.setModel(new AbstractListModel() {
        	String[] values = new String[] {"DFS", "BFS", "AStar"};
        	public int getSize() {
        		return values.length;
        	}
        	public Object getElementAt(int index) {
        		return values[index];
        	}
        });
        list.setSelectedIndex(3);
        list.setBackground(new Color(50, 205, 50));
        list.setBounds(954, 310, -184, -56);
        frame.getContentPane().add(list);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBox.setForeground(SystemColor.scrollbar);
        comboBox.setBackground(SystemColor.textInactiveText);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"DFS", "BFS ", "ASTAR"}));
        comboBox.setBounds(717, 194, 230, 60);
        frame.getContentPane().add(comboBox);
        
        textField = new JTextField();
        textField.setBackground(SystemColor.activeCaptionBorder);
        textField.setBounds(498, 73, 81, 43);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("N");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(527, 50, 52, 13);
        frame.getContentPane().add(lblNewLabel_1);
        
        txtNombreDeNoeuds = new JTextField();
        txtNombreDeNoeuds.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtNombreDeNoeuds.setText("nombre de noeuds g\u00E9n\u00E9r\u00E9s");
        txtNombreDeNoeuds.setBounds(29, 379, 230, 43);
        frame.getContentPane().add(txtNombreDeNoeuds);
        txtNombreDeNoeuds.setColumns(10);
        
        txtNombreDeNoeuds_1 = new JTextField();
        txtNombreDeNoeuds_1.setText("nombre de noeuds \u00E9xplor\u00E9s ");
        txtNombreDeNoeuds_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtNombreDeNoeuds_1.setColumns(10);
        txtNombreDeNoeuds_1.setBounds(29, 521, 230, 43);
        frame.getContentPane().add(txtNombreDeNoeuds_1);
        
        txtTempsDexcution = new JTextField();
        txtTempsDexcution.setText("Temps d'ex\u00E9cution");
        txtTempsDexcution.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTempsDexcution.setColumns(10);
        txtTempsDexcution.setBounds(323, 379, 230, 43);
        frame.getContentPane().add(txtTempsDexcution);
        
        txtNombreDeSolutions = new JTextField();
        txtNombreDeSolutions.setText("nombre de solutions trouv\u00E9es");
        txtNombreDeSolutions.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtNombreDeSolutions.setColumns(10);
        txtNombreDeSolutions.setBounds(323, 521, 230, 43);
        frame.getContentPane().add(txtNombreDeSolutions);
        
        textField_1 = new JTextField();
        textField_1.setBackground(SystemColor.activeCaptionBorder);
        textField_1.setBounds(93, 451, 96, 43);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBackground(SystemColor.activeCaptionBorder);
        textField_2.setColumns(10);
        textField_2.setBounds(93, 591, 96, 43);
        frame.getContentPane().add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setBackground(SystemColor.activeCaptionBorder);
        textField_3.setColumns(10);
        textField_3.setBounds(377, 451, 96, 43);
        frame.getContentPane().add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setBackground(SystemColor.activeCaptionBorder);
        textField_4.setColumns(10);
        textField_4.setBounds(377, 591, 96, 43);
        frame.getContentPane().add(textField_4);
    }
   
    private void createChessBoard() {
    	Integer[] solutions_bfs = BFS.solveNQueensBFS(n);
    	 int n = solutions_bfs.length; // determine the size of the board
    	        for (int row = 0; row < n; row++) { // iterate over all rows
    	            for (int col = 0; col < n; col++) { // iterate over all columns
    	            	JLabel square = new JLabel();
    	            	square.setOpaque(true);
    	            	// if there's a queen in this row and column
    	            	// print a queen symbol
    	                if (solutions_bfs[row] == col) {
    	                	 if ((row + col) % 2 == 0) {
    	                	        square.setBackground(Color.WHITE);
    	                	        ImageIcon queenIcon = new ImageIcon("black_queen.png");
    	                	        // Set the preferred size of the label to match the size of the square
    	                	        square.setPreferredSize(new Dimension(80,80));
    	                	        // Scale the icon to fit within the preferred size of the label
    	                	        queenIcon = new ImageIcon(queenIcon.getImage().getScaledInstance(square.getPreferredSize().width, square.getPreferredSize().height, Image.SCALE_SMOOTH));
    	                	        // Set the queen image as the icon for the label
    	                	        square.setIcon(queenIcon);
    	                	    } else {
    	                	    	square.setBackground(Color.BLACK);
    	                	        ImageIcon queenIcon = new ImageIcon("white_queen.png");
    	                	        // Set the preferred size of the label to match the size of the square
    	                	        square.setPreferredSize(new Dimension(80, 80));
    	                	        // Scale the icon to fit within the preferred size of the label
    	                	        queenIcon = new ImageIcon(queenIcon.getImage().getScaledInstance(square.getPreferredSize().width, square.getPreferredSize().height, Image.SCALE_SMOOTH));
    	                	        // Set the queen image as the icon for the label
    	                	        square.setIcon(queenIcon);
    	                	    }
    	                     // Set the horizontal and vertical alignment of the label to center the queen image
    	                     square.setHorizontalAlignment(JLabel.CENTER);
    	                     square.setVerticalAlignment(JLabel.CENTER);
    	                } else {
    	                	 if ((row + col) % 2 == 0) {
    	                         square.setBackground(Color.WHITE);
    	                     } else {
    	                         square.setBackground(Color.BLACK);
    	                     } 
    	                }
    	                chessBoardPanel.add(square);
    	                }
    	            System.out.println(); // move to the next row
    	        }
    }
	public ListModel getListModel() {
		return list.getModel();
	}
	public void setListModel(ListModel model) {
		list.setModel(model);
	}
}
