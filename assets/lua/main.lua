function Onclick()

	--Log:i("触发了");
	if ss==nil then
	
	as:setMarginleft("200%")
	at:addChild(view{id="ss",marginleft="0%",margintop="0%",width="200%",height="1000%",backgroundcolor="#1122cc"});
	else
	at:removeChild(ss)
	as:setMarginleft("0%")
	
	end	
end
function onCreated()
    
	local root = view{id="at",marginleft="0%",margintop="0%",width="1000%",height="1000%",backgroundcolor="#debbff"}
	 roost = view{id="as",marginleft="0%",margintop="0%",width="1000%",height="1000%",backgroundcolor="#debbff"}

	roost:addChild(button{id="buttons",marginleft="20%",Onclick="Onclick",margintop="200%",width="200%",height="200%",text="你好",backgroundcolor="#cccccc",alpha="50"})
	roost:addChild(edittext{id="b",marginleft="0%",margintop="800%",width="1000%",height="80%",backgroundcolor="#ffffff",alpha="50"})
   	root:addChild(roost)
	return  root
end
function OnNavBack()
end
function OnFronted()
end