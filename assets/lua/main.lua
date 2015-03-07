

function Onclick()

	Log:i(t.text);
	t.text = "点击事件触发成功";
end
function onCreated()
    
	local root = view{id="a",marginleft="0%",margintop="0%",width="100%",height="500%",backgroundcolor="#debbff"}
    root:addChild(button{id="t",text="按钮",marginleft="0%",margintop="0%",width="30%",height="500%",backgroundcolor="#eeccff",
    Onclick="Onclick"})

   -- root:addChild(subb)
       root:addChild(view{id="b",marginleft="60%",margintop="30%",width="30%",height="200%",backgroundcolor="#000000",
    })
    
	return  root
end