package cn.iolove.lui.widget;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.model.UIModel;
import android.view.View;
import android.widget.Button;

public class ButtonWidget extends AbstractWidget {

	private Button btn;
	public ButtonWidget(UIModel m) {
		super(m);
		btn = new Button(RuntimeContext.getInstance().rl.getActivityContext());
		loadModel();
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getInnerView() {
		// TODO Auto-generated method stub
		return btn;
	}

	@Override
	protected void loadModel() {
		WidgetUtils.loadModel(model, this);
		String str = model.getValueByKey("text");
		if(str!=null)
		{
			btn.setText(str);
			
		}
		
		

	}



}
