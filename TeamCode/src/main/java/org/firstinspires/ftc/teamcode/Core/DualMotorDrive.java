package org.firstinspires.ftc.teamcode.Core;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * DualMotorDrive
 * Runs the drivetrain of the robot.
 */
public class DualMotorDrive {

    //private fields
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;


    public void init (HardwareMap hardwareMap) {

    // Initialize DC motor variables
    private DcMotor leftMotor;
    private DcMotor rightMotor;


    // Map DC motor variables to driver hub
    public DualMotorDrive (HardwareMap hardwareMap) {
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");

        // Sets
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
    }


    /** setPowers
     * Sets the Ensures that the range of power sent to the motors is
     *
     * @param powerLeft - power sent to the left motor
     * @param powerRight - power to the right motor
     */
    public void setPowers(double powerLeft, double powerRight) {
        double largest = 1.0;


        largest = Math.max(largest, Math.abs(leftPower));
        largest = Math.max(largest, Math.abs(rightPower));

        leftMotor.setPower(leftPower / largest);
        rightMotor.setPower(rightPower / largest);

        // Takes the largest value out of 1.0, powerLeft, and powerRight
        largest = Math.max(largest, Math.abs(powerLeft));
        largest = Math.max(largest, Math.abs(powerRight));


        // Sets the power of the motors in relation to largest
        leftMotor.setPower(powerLeft / largest);
        rightMotor.setPower(powerRight / largest);
    }

    public void telemetry(Telemetry telemetry, double leftPower, double rightPower) {
        telemetry.addData("Left Stick:", leftPower);
        telemetry.addData("Right Stick:", rightPower);
    }
}
