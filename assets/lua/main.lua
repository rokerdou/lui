function Onclick()

	--Log:i("触发了");
	buttons:setText("你啊后啊")
	App:pushPage("second");
end
function onCreated()
    
	local root = view{id="a",marginleft="0%",margintop="0%",width="1000%",height="1000%",backgroundcolor="#debbff"}

	root:addChild(button{id="buttons",marginleft="20%",Onclick="Onclick",margintop="200%",width="200%",height="200%",text="你好",backgroundcolor="#cccccc",alpha="50"})
	root:addChild(edittext{id="b",marginleft="0%",margintop="800%",width="1000%",height="80%",backgroundcolor="#ffffff",alpha="50"})
   
	return  root
end
function OnNavBack()
end
function OnFronted()
end