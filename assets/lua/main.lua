function Onclick()

	--Log:i("触发了");
	if ss:getHidden() then
	Log:i("显示图片");
	ss:setHidden(false)
	as:setMarginleft("200%")

	else
	Log:i("隐藏");
	ss:setHidden(true)
	as:setMarginleft("0%")
	
	
	end	
end
function sOnclick()
App:pushPage("second");
end
function onCreated()
    
	local root = view{id="at",marginleft="0%",margintop="0%",width="1000%",height="1000%",backgroundimage="image/bg2.jpg"}
	 roost = view{id="as",marginleft="0%",margintop="0%",width="1000%",height="1000%",backgroundimage="image/bg2.jpg"}

	roost:addChild(button{id="buttons",marginleft="20%",Onclick="Onclick",margintop="200%",width="800%",height="110%",backgroundimage="image/login-button.png",backgroundscale="fill",text="你好",backgroundcolor="#cccccc",alpha="0"})
	roost:addChild(edittext{id="b",marginleft="0%",margintop="800%",width="1000%",height="80%",backgroundcolor="#ffffff",alpha="40"})
    local slide = view{id="ss",hidden=true,marginleft="0%",margintop="0%",width="350%",height="1000%",backgroundimage="image/bg.jpg",alpha="0"};
	slide:addChild(button{id="sbutton",marginleft="1%",margintop="200%",width="200%",height="110%",backgroundcolor="#ffffff",text="切换",Onclick="sOnclick"})
	
	root:addChild(slide)
   	root:addChild(roost)
	return  root
end
function OnNavBack()
App:popPage();
end
function OnFronted()
end