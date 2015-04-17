local math = require('math')  
function Onclick()

end
function sOnclick()
App:pushPage("second");
end

function onCreated()
    
	local root = view{id="at",marginleft="0%",margintop="0%",width="1000%",height="1000%",backgroundcolor="#303030"}
	--root:addChild(view{marginleft="0%",margintop="0%",width="1000%",height="200%",backgroundimage="image/fengjing10.png",alpha="50"})
	root:addChild(view{marginleft="225%",margintop="0%",width="550%",height="180%",backgroundimage="image/logo.png"})
	local login_btn = button{id="login_btn",marginleft="250%",margintop="600%",width="500%",height="100%",text="登陆",Onclick="Login",backgroundcolor="#ccff11"}
	root:addChild(edittext{id="user",marginleft="250%",margintop="300%",width="550%",height="80%",fontsize="12",backgroundcolor="#ffffff",alpha="50",type="password"})
	root:addChild(edittext{id="pwd",marginleft="250%",margintop="400%",width="550%",height="80%",fontsize="12",backgroundcolor="#ffffff",alpha="50",type="password"})

	root:addChild(login_btn)
	root:addChild(button{margintop="900%",marginleft="0%",width="1000%",backgroundcolor="#000000",height="100%",textcolor="#EAEAEA",text="窦佳毕业设计",alpha="50"})
	
	--local checkline=view{marginleft="0%",margintop="500%",width="1000%",height="80%",backgroundcolor="#cccccc",alpha="50"}
	root:addChild(checkbox{id="stu_checkbox",margintop="500%",marginleft="260%",width="100%",height="70%"})
	--root:addChild(checkline)
	return  root
end
function Login()

Log:i("进入了登陆函数")
busy:show("正在登陆中");
--login:Login(user:getText(),pwd:getText(),3,function() busy:dismiss() App:pushPage("second") end,function() end);
Log:i("退出登陆函数")
 busy:dismiss() App:pushPage("second")
--busy:dismiss();
end
function OnNavBack()
App:popPage();
end
function OnFronted()
end