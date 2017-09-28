package com.automated_testing.model;

import java.util.HashMap;
import java.util.Map;

import com.automated_testing.Phone.Token;

public class phoneFactory {
	private Map<Token, Phone> map = new HashMap<Token, Phone>();
	public phoneFactory() {
		map.put(Token.GUANGDONG , new GuangDong());
		map.put(Token.SICHUAN , new SiChuan());
		map.put(Token.ANHUI, new AnHui());
		map.put(Token.JIANGSU, new JiangSu());
		map.put(Token.ZHEJIANG, new ZheJiang());
		map.put(Token.SHANDONG, new ShanDong());
		map.put(Token.HUNAN, new HuNan());
		map.put(Token.WUHAN, new WuHan());
		map.put(Token.SHANGHAI, new ShangHai());
		map.put(Token.FUJIAN, new FuJian());
		map.put(Token.HENAN, new HeNan());
		map.put(Token.LIAONING,new LiaoNing());
		map.put(Token.BEIJING, new BeiJing());
		map.put(Token.BEICHENG, new BeiCheng());
		map.put(Token.HEBEI, new HeBei());
		map.put(Token.CHONGQING, new ChongQing());
		map.put(Token.HEILONGJIANG, new HeiLongJiang());
		map.put(Token.SHANXI, new ShanXi());
		map.put(Token.LIANTONG, new LianTong());
		map.put(Token.HAINAN, new HaiNan());
		map.put(Token.GUANGXI, new GuangXi());
		map.put(Token.SHANXIHOME, new ShanXiHome());
		map.put(Token.NINGXIA, new NingXia());
		map.put(Token.NEIMENGGU, new NeiMengGu());
		map.put(Token.JILIN, new JiLin());
		map.put(Token.GANSU, new GanSu());
		map.put(Token.GUIZHOU, new GuiZhou());
		map.put(Token.JIANGXI, new JiangXi());
		map.put(Token.QINGHAI, new QingHai());
		map.put(Token.TIANJIN, new TianJin());
	}
	public Phone getPhoneByToken(Token token){
		return map.get(token);
	}
	
}
