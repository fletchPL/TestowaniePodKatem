package Glowny;

public class CallBackTwoImpl implements CallBackTwo
{
	@Override
	public void CallBackToCallBack(String[] str) 
	{
		CallBackImpl callBack = new CallBackImpl(); 
		FileOperations fOp = new FileOperations();
		
		fOp.SaveFile(str, callBack);		
	}
}
