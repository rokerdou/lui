
View = {}
View.__index = View

function View:addChild(child)
    local sub = self.subitems
    if not sub then
        sub = {}
        self.subitems = sub
    end
    
    table.insert(sub, child)
end

function view(args)
    local m = {}
    setmetatable(m, View)
    m.qName = "view"
    if args then
    	for k,v in pairs(args) do
    		m[k] = v
    	end
    end
    return m
end
function edittext(args)
    local m = {}
    m.qName = "edittext"
    m.height = 44
    if args then
    	for k,v in pairs(args) do
    		m[k] = v
    	end
    end
    return m
end
function button(args)
    local m = {}
    m.qName = "button"
    m.height = 44
    if args then
    	for k,v in pairs(args) do
    		m[k] = v
    	end
    end
    return m
end
function table2json(t)   
        local function serialize(tbl)   
                local tmp = {}   
                for k, v in pairs(tbl) do   
                        local k_type = type(k)   
                        local v_type = type(v)   
                        local key = (k_type == "string" and "\"" .. k .. "\":")   
                            or (k_type == "number" and "")   
                        local value = (v_type == "table" and serialize(v))   
                            or (v_type == "boolean" and tostring(v))   
                            or (v_type == "string" and "\"" .. v .. "\"")   
                            or (v_type == "number" and v)   
                        tmp[#tmp + 1] = key and value and tostring(key) .. tostring(value) or nil   
                end   
                if table.maxn(tbl) == 0 then   
                        return "{" .. table.concat(tmp, ",") .. "}"  
                else   
                        return "[" .. table.concat(tmp, ",") .. "]"  
                end   
        end   
        assert(type(t) == "table")   
        return serialize(t)   
end  
function Onclick()

	Log:i(t.text);
	if t.text=="按钮"then
	t:setText("点击事件触发成功");
	--a:addChild(view{id="c",marginleft="20%",margintop="500%",width="60%",height="300%",backgroundcolor="#cccccc"});
    a:removeChild(b)
 
    else
    t:setText("按钮")
    
    a:addChild(view{id="b",marginleft="60%",margintop="30%",width="30%",height="200%",backgroundcolor="#000000"})
     Log:i(b.id);
    end
end
function onCreated()
    
	local root = view{id="a",marginleft="0%",margintop="0%",width="100%",height="1000%",backgroundcolor="#debbff"}
    root:addChild(button{id="t",text="按钮",marginleft="0%",margintop="0%",width="30%",height="500%",backgroundcolor="#eeccff",
    Onclick="Onclick"})

   root:addChild(view{id="b",marginleft="60%",margintop="30%",width="30%",height="200%",backgroundcolor="#000000"})
   
	return  root
end