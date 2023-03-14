import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Nqueens_Interface {

    private JFrame frame;
    private JPanel chessBoardPanel;
    private int n;

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

        JButton btnNewButton = new JButton("BFS");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(752, 148, 150, 78);
        frame.getContentPane().add(btnNewButton);

        JButton btnDfs = new JButton("DFS");
        btnDfs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnDfs.setBounds(752, 260, 150, 78);
        frame.getContentPane().add(btnDfs);

        JButton btnAstar = new JButton("AStar");
        btnAstar.setBounds(752, 378, 150, 78);
        frame.getContentPane().add(btnAstar);

        JLabel lblNewLabel = new JLabel("select a method ");
        lblNewLabel.setToolTipText("");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
        lblNewLabel.setBounds(767, 34, 197, 78);
        frame.getContentPane().add(lblNewLabel);

        chessBoardPanel = new JPanel();
        chessBoardPanel.setBounds(10, 10, 732, 632);
        chessBoardPanel.setLayout(new GridLayout(n, n));
        frame.getContentPane().add(chessBoardPanel);
    }
   
    private void createChessBoard() {
    	int[] solutions_bfs = BFS.solveNQueensBFS(n);
    	 int n = solutions_bfs.length; // determine the size of the board
    	        for (int row = 0; row < n; row++) { // iterate over all rows
    	            for (int col = 0; col < n; col++) { // iterate over all columns
    	            	JLabel square = new JLabel();
    	            	square.setOpaque(true);
    	                if (solutions_bfs[row] == col) { // if there's a queen in this row and column
    	                    System.out.print("Q "); // print a queen symbol
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
}
