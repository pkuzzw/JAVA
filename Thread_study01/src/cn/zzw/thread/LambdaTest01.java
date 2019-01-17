package cn.zzw.thread;
/**
 * Lambda推导
 * @author zzw
 *
 */

public class LambdaTest01 {
	//静态内部类
	static class Like2 implements ILike{

		@Override
		public void lambda() {
			// TODO Auto-generated method stub
			System.out.println("I like Lanbda -----2");
			
		}
		
	}

	public static void main(String[] args) {
		ILike like=new Like();
		like.lambda();
		
		like=new Like2();
		like.lambda();
		//匿名内部类
		like=new ILike() {
			
			@Override
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("I like lanbda------------3");
			}
		};
		like.lambda();
		
		
	 
		
		
		
	}
}


interface ILike{
	void lambda();
}

class Like implements ILike{

	@Override
	public void lambda() {
		// TODO Auto-generated method stub
		System.out.println("I like Lanbda");
		
	}
	
}