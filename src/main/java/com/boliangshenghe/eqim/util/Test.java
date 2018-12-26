package com.boliangshenghe.eqim.util;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;

public class Test {

	public static void main(String[] args) {
		/*JiebaSegmenter segmenter = new JiebaSegmenter();
	    String[] sentences =
	        new String[] {"这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。", "我不喜欢日本和服。", "雷猴回归人间。",
	                      "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作", "结果婚的和尚未结过婚的"};
	    for (String sentence : sentences) {
	        System.out.println(segmenter.process(sentence, SegMode.INDEX).toString());
	    }*/
		
		/*JiebaSegmenter segmenter = new JiebaSegmenter();
		String shortStr = "南京市长江大桥";
		String jiebas = segmenter.process(shortStr, SegMode.INDEX).toString();
		System.out.println(jiebas);*/
		String ss = "4F9D669D-ADB9-44C3-A036-76DA32A39FBF";
		System.out.println(ss.length());
	}

}
