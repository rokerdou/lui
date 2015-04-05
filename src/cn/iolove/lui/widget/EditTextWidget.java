package cn.iolove.lui.widget;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.model.ButtonModel;
import cn.iolove.lui.model.EditTextModel;
import cn.iolove.lui.model.UIModel;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditTextWidget extends AbstractWidget {

	private TextView et;
	public EditTextWidget(UIModel m) {
		super(m);
		et = new EditText(RuntimeContext.getInstance().rl.getActivityContext());
		loadModel();
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getInnerView() {
		// TODO Auto-generated method stub
		return et;
	}

	@Override
	protected void loadModel() {
		WidgetUtils.loadModel(model, this);
		final EditTextModel bm = (EditTextModel)model;
		String str = ((EditTextModel)model).text;
		if(str!=null)
		{
			et.setText(str);
			
		}
	
		// TODO Auto-generated method stub

	}

}
