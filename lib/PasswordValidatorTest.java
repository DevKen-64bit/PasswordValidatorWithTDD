package lib;

public class PasswordValidatorTest{
    
    public static void run() {
        System.out.println("--- Running Password Validator Tests ---");
        
        // Test Case 1: รหัสผ่านสั้นควรจะ INVALID
        PasswordStrength result1 = PasswordValidator.validate("123");
        if (result1 == PasswordStrength.INVALID) {
            System.out.println("Test Case 1 Passed: Short password is INVALID.");
        } else {
            System.out.println("Test Case 1 FAILED: Expected INVALID but got " + result1);
        }
        // Test Case 2: รหัสผ่านยาวเกินไปจะ INVALID
        PasswordStrength result2 = PasswordValidator.validate("12345678910111213141516");
         if (result2 == PasswordStrength.INVALID){
            System.out.println("Test Case 2 Passed: too long password is INVALID.");
         }else {
            System.out.println("Test Case 2 FAILED: Expected INVALID but got " + result2);
        }
        // Test Case 3: ถ้าใส่ถูกต้องตามเงื่อนไขจะ Strong
        PasswordStrength result3 = PasswordValidator.validate("12345678zX@");
        if(result3 == PasswordStrength.STRONG){
            System.out.println("Test Case 3 Passed: password has 4 requirements is Strong.");
        }else{
            System.out.println("Test Case 3 FAILED: Expected INVALID but got " + result3);
        }
        // Test Case 4: เช็คว่ารหัสผ่านมีช่องว่างจะ Invalid
        PasswordStrength result4 = PasswordValidator.validate("123 12345678");
        if(result4 == PasswordStrength.INVALID){
            System.out.println("Test Case 4 Passed: null spece password is INVALID.");
        }else{
            System.out.println("Test Case 4 FAILED: Expected INVALID but got " + result4);
        }
        // Test Case 5: เช็คว่าถ้าเข้าเกณฑ์แค่อย่างเดียวจะ Weak
        PasswordStrength result5 = PasswordValidator.validate("1234567890");
        if(result5 == PasswordStrength.WEAK){
            System.out.println("Test Case 5 Passed: password has only 1 requirement is Weak.");
        }else{
            System.out.println("Test Case 5 FAILED: Expected INVALID but got " + result5);
        }
        // Test Case 6: เช็คว่าถ้าเข้าเกณฑ์แค่ 2อย่างจะ Medium
        PasswordStrength result6 = PasswordValidator.validate("1234567890z");
        if(result6 == PasswordStrength.MEDIUM){
            System.out.println("Test Case 6 Passed: password has 2 requirements is Medium.");
        }else{
            System.out.println("Test Case 6 FAILED: Expected INVALID but got " + result6);
        }
         // Test Case 7: เช็คว่าถ้าเข้าเกณฑ์แค่ 3 อย่างจะ Medium
        PasswordStrength result7 = PasswordValidator.validate("1234567890zX");
        if(result7 == PasswordStrength.MEDIUM){
            System.out.println("Test Case 7 Passed: password has 3 requirements is Medium.");
        }else{
            System.out.println("Test Case 7 FAILED: Expected INVALID but got " + result7);
        }
        // Test Case 8: เช็คว่าถ้ามีแต่ตัวอักษรพิมเล็ก
        PasswordStrength result8 = PasswordValidator.validate("zzzzzzzzzzzzz");
        if(result8 == PasswordStrength.WEAK){
            System.out.println("Test Case 8 Passed: password has only Lower character is Weak.");
        }else{
            System.out.println("Test Case 8 FAILED: Expected INVALID but got " + result8);
        }
        
        // Test Case 9: เช็คว่าถ้ามีตัวอักษรใหญ่กับเล็ก
        PasswordStrength result9 = PasswordValidator.validate("zzzzzzzzzzzzzXXxx");
        if(result9 == PasswordStrength.MEDIUM){
            System.out.println("Test Case 9 Passed: password has only Upper and Lower character is Medium.");
        }else{
            System.out.println("Test Case 10 FAILED: Expected INVALID but got " + result9);
        }
        // Test Case 10: เช็คว่าถ้าใส่ภาษาไทยลงไป
        PasswordStrength result10 = PasswordValidator.validate("สมชาย");
        if(result10 == PasswordStrength.INVALID){
            System.out.println("Test Case 10 Passed: The Password has Character isn't Allow is INVALID");
        }else{
            System.out.println("Test Case 10 FAILED: Expected INVALID but got " + result10);
        }
        // Test Case 11: เช็คว่าถ้าใส่ตัวอักษรแปลกๆลงไปที่ไม่ได้อนุญาตรวใกับตัวอักษรอื่นๆ
        PasswordStrength result11 = PasswordValidator.validate("123456789Ken)()$@-+");
        if(result10 == PasswordStrength.INVALID){
            System.out.println("Test Case 11 Passed: The Password has Character isn't Allow is INVALID");
        }else{
            System.out.println("Test Case 11 FAILED: Expected INVALID but got " + result11);
        }
        System.out.println("--------------------------------");
    }
}