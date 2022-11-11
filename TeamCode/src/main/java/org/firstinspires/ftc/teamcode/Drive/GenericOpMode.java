package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Core.TriMotorDrive;


/** GenericOpMode
 * Generic OpMode to be used as the starting point for the robot code. Ideally, this should be modified and
 * eventually deprecated. Uses Arcade Drive.
 */

@TeleOp
public class GenericOpMode extends OpMode {

    //Claw
    private Servo leftClaw = null;

    private Servo rightClaw = null;

    TriMotorDrive drive = new TriMotorDrive();

    @Override
    public void init() { //INIT - When OpMode is init but not Started
        telemetry.addData("STATUS:", "Initialized"); // the FTC equivalent to println()
        telemetry.addData("FTC Team #", "20718");

        //Claw
        leftClaw = hardwareMap.get(Servo.class, "claw_left");
        rightClaw = hardwareMap.get(Servo.class, "claw_right");


        //for now because I am lazy I will call loop within initialization because that's a good and smart idea.
        //obviously change this. This is bad style, this is bad code.
        //REMOVE IN PRODUCTION - NOT LEGAL
        loop();

    }

    @Override
    public void loop() { //START - after start button is pushed

        //Open/Close Claw
        telemetry.addData("Claw_Left", leftClaw.getPosition());
        telemetry.addData("Claw_Right", rightClaw.getPosition());
        if (gamepad1.a){
            leftClaw.setPosition(0.3);
            rightClaw.setPosition(0.6);
        } else if (gamepad1.b) {
            leftClaw.setPosition(0.6);
            rightClaw.setPosition(0.2);
        }

        double forward = -gamepad1.left_stick_y;
        double right = gamepad1.left_stick_x;
        double center = 0;

        if (gamepad1.left_bumper) {
            center = - 1;
        } else if (gamepad1.right_bumper){
            center = 1;
        } else {
            center = 0;
        }

        drive.setPowers(forward + right, forward - right, center);

    }
}
