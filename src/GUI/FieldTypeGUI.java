package GUI;

import desktop_fields.*;
import java.awt.Color;
import desktop_board.Board;

import desktop_board.Center;
import desktop_codebehind.SwingComponentFactory;

public class FieldTypeGUI extends Ownable{

	private SwingComponentFactory factory = new SwingComponentFactory();
	
	public static class Builder extends Field.Builder<FieldTypeGUI.Builder> implements iBuilder{
		public Builder() {
			this.bgColor = Board.BASECOLOR;
			this.fgColor = Color.BLACK;
		}
		
		@Override
		@SuppressWarnings("synthetic-access")
		public FieldTypeGUI build(){
			return new FieldTypeGUI(this.bgColor, this.fgColor, this.title, this.subText, this.description);
		}
	}
	
	private FieldTypeGUI(Color bgColor, Color fgColor, String title, String subText, String description){
		super(bgColor, fgColor, title, subText, description, "");
        this.layered.add(this.titleLabel, this.factory.createGridBagConstraints(0, 0));
	}
	
	@Override
    public void displayOnCenter() {
        super.displayOnCenter();
        Center.label[1].setText(super.description);
        super.displayCarOnCenter();
    }
	
}
