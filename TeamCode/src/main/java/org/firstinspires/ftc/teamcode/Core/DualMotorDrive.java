package org.firstinspires.ftc.teamcode.Core;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/** DualMotorDrive
 *  Runs the drivetrain of the robot.
 */
@TeleOp
public class DualMotorDrive {
    //private fields
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;
    private DcMotor centerMotor = null;


    public void init (HardwareMap hardwareMap) {
        // Variable init
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");
        // Set modes of motors
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

    }


    /** setPowers
     * Ensures that the range of power sent to the motors is
     *
     * @param leftPower - power sent to the left motor
     * @param rightPower - power to the right motor
     */
    public void setPowers(double leftPower, double rightPower){
        double largest = 1.0;

        largest = Math.max(largest, Math.abs(leftPower));
        largest = Math.max(largest, Math.abs(rightPower));

        leftMotor.setPower(leftPower / largest);rightMotor.setPower(rightPower / largest);

    }

}
