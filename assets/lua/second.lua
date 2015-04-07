function onCreated()
    
	local root = view{id="a",marginleft="0%",margintop="0%",width="1000%",height="1000%",backgroundimage="image/bgs.jpg",alpha="10"}

   root:addChild(button{id="button",marginleft="20%",Onclick="Onclick",margintop="200%",width="200%",height="200%",text="Second",backgroundcolor="#ff11aa",alpha="50"})
 --  root:addChild(view{id="b",marginleft="0%",margintop="500%",width="1000%",height="1000%",backgroundcolor="#000000"})
   
	return  root
end
function Onclick()
App:pushPage("main");

end
function OnFronted()
end
function OnNavBack()
App:popPage();
end