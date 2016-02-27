package view;

public class QuerySetter {
	private ButtonBlock btnBlock;
	public QuerySetter(ButtonBlock btnBlock)
	{
		this.btnBlock = btnBlock;
		setQueryCommand();
	}
	
	private void setQueryCommand()
	{
		StringBuilder queryCommand = new StringBuilder();
		switch(btnBlock.getLocation().x)
		{
			case 0: queryCommand.append("query1 ");
				break;
			case 1: queryCommand.append("query2 ");
				break;
			case 2: queryCommand.append("query3 ");
				break;
			case 3: queryCommand.append("query4 ");
				break;
			case 4: queryCommand.append("query5 ");
				break;
			case 5: queryCommand.append("query6 ");
				break;
			case 6: queryCommand.append("query7 ");
				break;
			default: 
				break;
		}
		
		switch(btnBlock.getLocation().y)
		{
			case 0: queryCommand.append("original");
				break;
			case 1: queryCommand.append("heuristics");
				break;
			case 2: queryCommand.append("views");
				break;
			case 3: queryCommand.append("indexed");
				break;
			case 4: queryCommand.append("stored procedures");
				break;
			default:
				break;
		}
		
		this.btnBlock.setCommand(queryCommand.toString());
	}
	
	
	public static ButtonBlock searchContext(ButtonBlock btnBlock)
	{
		new QuerySetter(btnBlock);
		return btnBlock;
	}
}
