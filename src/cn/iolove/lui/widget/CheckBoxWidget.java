package cn.iolove.lui.widget;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.model.CheckBoxModel;
import cn.iolove.lui.model.UIModel;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CheckBoxWidget extends ViewWidget {

	private CheckBox cb=null;
	final CheckBoxModel mol =(CheckBoxModel)model;
	public CheckBoxWidget(UIModel m) {
		
		super(m);
		
		cb= new CheckBox(RuntimeContext.getInstance().rl.getActivityContext());
		cb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				cb.setChecked(!mol.Oncheck);
				mol.Oncheck=!mol.Oncheck;
				
			}
		});
		lv.addView(cb);
	
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getInnerView() {
		// TODO Auto-generated method stub
		return lv;
	}
	@Override
	protected void loadModel() {
		// TODO Auto-generated method stub
		WidgetUtils.loadModel(model, this);
		super.loadModel();
		lv.getBackground().setAlpha(0);
	
		if(cb!=null)
		cb.setChecked(mol.Oncheck);
		

	}

	@Override
	public void Ondestroy() {
		// TODO Auto-generated method stub

	}

}
