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
    private DcMotor leftMotor;
    private DcMotor rightMotor;


    public DualMotorDrive(HardwareMap hardwareMap) {
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
    }


    /**
     * setPowers
     * Ensures that the range of power sent to the motors is
     *
     * @param leftPower  - power sent to the left motor
     * @param rightPower - power to the right motor
     */
    public void setPowers(double leftPower, double rightPower) {
        double largest = 1.0;

        largest = Math.max(largest, Math.abs(leftPower));
        largest = Math.max(largest, Math.abs(rightPower));

        leftMotor.setPower(leftPower / largest);
        rightMotor.setPower(rightPower / largest);
    }

    public void telemetry(Telemetry telemetry, double leftPower, double rightPower) {
        telemetry.addData("Left Stick:", leftPower);
        telemetry.addData("Right Stick:", rightPower);
    }
}
