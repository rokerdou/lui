function Onclick()

	--Log:i("触发了");
	if ss==nil then
	
	--as:setMarginleft("350%")
	at:addChild(view{id="ss",marginleft="0%",margintop="0%",width="350%",height="1000%",backgroundcolor="#1122cc",alpha="40"});
	ss:addChild(button{id="sbutton",marginleft="1%",margintop="200%",width="200%",height="110%",backgroundcolor="#ffffff",text="切换",Onclick="sOnclick"})
	else
	at:removeChild(ss)
	as:setMarginleft("0%")
	
	end	
end
function sOnclick()
App:pushPage("second");
end
function onCreated()
    
	local root = view{id="at",marginleft="0%",margintop="0%",width="1000%",height="1000%",backgroundimage="image/pen.png"}
	 roost = view{id="as",marginleft="0%",margintop="0%",width="1000%",height="1000%",backgroundimage="image/pen.png"}

	roost:addChild(button{id="buttons",marginleft="20%",Onclick="Onclick",margintop="200%",width="800%",height="110%",backgroundimage="image/login-button.png",backgroundscale="fill",text="你好",backgroundcolor="#cccccc",alpha="0"})
	roost:addChild(edittext{id="b",marginleft="0%",margintop="800%",width="1000%",height="80%",backgroundcolor="#ffffff",alpha="40"})
   	root:addChild(roost)
	return  root
end
function OnNavBack()
end
function OnFronted()
end