class drawBinarySearchTree
{
	private static int defaultWidth = 600;
	private static int defaultHeight = 600;
	
	public static void main(String[] args)
	{
		if( args.length < 1 )
		{
			System.out.println("format: drawBinarySearchTree v1 v2 ... vn");
			System.exit(0);
		}
		
		DrawingAreaNew da;
		javax.swing.JFrame f;
		javax.swing.JPanel daPanel;
		javax.swing.JPanel mainPanel;
		javax.swing.JScrollPane scrollPane;
		
		int width = defaultWidth;
		int height = defaultHeight;
				
		f = new javax.swing.JFrame();
		BinarySearchTreeFunctions tree = new BinarySearchTree(); 
		da = new DrawingAreaNew(tree, args);
		
		daPanel = new javax.swing.JPanel();
		daPanel.setLayout(new java.awt.BorderLayout());
		mainPanel = new javax.swing.JPanel();
		mainPanel.setLayout(new java.awt.BorderLayout());
		daPanel.add(da, java.awt.BorderLayout.CENTER);
		daPanel.validate();
		daPanel.setVisible(true);
		f.addKeyListener(da);
		
		scrollPane = new javax.swing.JScrollPane(daPanel);
		scrollPane.validate();
		scrollPane.setVisible(true);
		mainPanel.add(scrollPane, java.awt.BorderLayout.CENTER);
		
		f.setPreferredSize(new java.awt.Dimension(width, height));
		f.setMinimumSize(new java.awt.Dimension(width, height));
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		f.setContentPane(mainPanel);
		f.validate();
		f.setVisible(true);
	}
}
