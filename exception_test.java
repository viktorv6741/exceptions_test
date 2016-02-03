1. What will be the output of the program?

public class Foo {
    public static void main(String[] args) {

        try{
            return;
        }finally{
            System.out.println("Finally"); // finally отрабатывает всегда, 
        }
    }
}


A. Finally


/////////////////////////////////////////////////////////////////////////////////////////////////


2. What will be the output of the program?

   try {
            int x = 0;
            int y = 5 / x;
        } catch (Exception e) {             // Тут поймает  exception т.к. класс Exception является родительским по отношению к ArithmeticException
            System.out.println("Exception");
        } catch (ArithmeticException ae) {  // Тут компилятор умничает, показывая, что exception был отловлен в первом catch-е.)
		                                        
            System.out.println("ArithmeticException");
        }
        System.out.println("finished");
		
		
C. Compilation fails		


/////////////////////////////////////////////////////////////////////////////////////////////////

3. What will be the output of the program?

public class X {
    public static void main(String[] args)  {
  try{
            badMethod();              // Поймает исключение
            System.out.println("A");  // Выполнено не будет т.к. словит исключение в предыдущей строчке
        }catch (Exception ex){        // Исключение обработанно не будет т.к. должно быть Error
            System.out.print("B");
        }finally {                    // finally отработает в любом случае
            System.out.println("C");
        }
        System.out.println("D");      // Выведенно не будет т.к. исключение не было обработанно и работа программы была остановленна
    }

    public static void badMethod(){
        throw new Error() ;
    }
}
	
	
С. C is printed before exiting with an error message	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////

 4. What will be the output of the program?
 
 public class X {
    public static void main(String[] args)  {

        try{
            badMethod();                // Поймает исключение
            System.out.println("A");    // Выполнено не будет т.к. словит исключение в предыдущей строчке
        }catch (RuntimeException  ex){  // Исключение будет обработанно и выведенно B на консоль
            System.out.print("B");
        }catch (Exception  ex){         // Выполнено не будет т.к. словит исключение в предыдущей строчке 
            System.out.print("C");
        }finally {                      // finally отработает всегда будет выведенно D на консоль
            System.out.println("D");
        }
        System.out.println("E");        // выведит E на консоль
    }

    public static void badMethod(){
        throw new RuntimeException() ;
    }
}
  
  
С. BDE


/////////////////////////////////////////////////////////////////////////////////////////////////


 5. What will be the output of the program?

public class RTExcept {

    public static void throwit(){
        System.out.println("throwit");
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try{
            System.out.println("hello");    // Выведет на экран hello
            throwit();                      // Выведет сначала throwit, затем словит exception
        }catch (Exception re){              // Т.к. RuntimeException наследуется от Exception исключение будет обработанно
		                                    // и выведенно catch
            System.out.println("caught");
        }finally {
            System.out.println("finally");  // finally отработает в любом случае и выведет finally
        }
        System.out.println("after");        //  Продолжится выполненте программы и выведет after
    }
}

D. hello throwit caught finally after
 
 
/////////////////////////////////////////////////////////////////////////////////////////////////


6. What will be the output of the program?	

public class Test {

    public static void aMethod() throws Exception{   // throws Exception говорит о том, что исключение в данном
	                                                 // методе обработанно не будет
        try {
            throw new Exception();      // Генерируем исключение
        }finally {
            System.out.println("finally"); // будет выведенно на экран finally
        }
    }// исключение в данном методе остаётся не обработанным
	

    public static void main(String[] args) {

       try {
           aMethod(); // ловим исключение и выводим finally на консоль
       } catch (Exception e) { 
           System.out.println("exception"); // обрабатываем и выводим exception на консоль
       }
        System.out.println("finished");  // продолжаем выполненте программы и выводим finished
    }
}


Answer: finally exception finished


/////////////////////////////////////////////////////////////////////////////////////////////////


7. What will be the output of the program?


  public class X {
            public static void main(String[] args)  {

                try{
                    badMethod();
                    System.out.println("A");  // Здесь ошибки никакой нет, просто метод который ничего не выполняет, 
					                          // будет выведенно A  
                }catch (RuntimeException  ex){ // Этот блок кода не сработает
                    System.out.print("B");
                }finally {
                    System.out.println("C");   // Сработает в любом случае, выведит C
                }
                System.out.println("D");       // Выведит D
            }

            public static void badMethod(){
            }
        }
		
		
C. ACD


///////////////////////////////////////////////////////////////////////////////////////////////// 


8. What will be the output of the program?

        public class X {
            public static void main(String[] args)  {

                try{
                    badMethod();   // ловим 
                    System.out.println("A");
                }catch (Exception  ex){ // переходим сюда и выводим B
                    System.out.print("B");
                }finally {
                    System.out.println("C"); // Выводим С
                }
                System.out.println("D"); // Продолжаем выполнение программы и выводим D
            }

            public static void badMethod(){
                throw new RuntimeException(); // Генерируем исключение
            }
        }

D. BCD

		
/////////////////////////////////////////////////////////////////////////////////////////////////


9. What will be the output of the program?


ublic class MyProgram {

    public static void main(String[] args) {

        try{
            System.out.println("Hello world");
        }finally{
            System.out.println("Finally executed");
        }
    }
}

D. Hello world  Finally excecuting


/////////////////////////////////////////////////////////////////////////////////////////////////


10. What will be the output of the program?
 

class Exc0 extends Exception{
	
}

class Exc1 extends Exc0{
	
}

public class Test {
    public static void main(String[] args) {

        try{
            throw new Exc1();
        }catch (Exc0 e0){
            System.out.println("Ect0 caught");  // будет Ect0 caught т.к. наследуется от Exc1 
        }catch (Exception e){
            System.out.println("exception caught");
        }
    }
}


A. Ect0 caught