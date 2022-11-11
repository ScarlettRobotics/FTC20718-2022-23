package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.TriMotorDrive;


/** GenericOpMode 2 player
 * Designed for driving to be on controller 1, upper systems on controller 2.
 * Generic OpMode to be used as the starting point for the robot code. Ideally, this should be modified and
 * eventually deprecated. Function using tank drive
 */

@TeleOp
public class ArcadeDrive2p extends OpMode {

    //Claw
    private Servo leftClaw = null;

    private Servo rightClaw = null;

    TriMotorDrive drive = new TriMotorDrive();
    ClawCore claw = new ClawCore();

    @Override
    public void init() { //INIT - When OpMode is init but not Started
        telemetry.addData("STATUS:", "Initialized"); // the FTC equivalent to println()
        telemetry.addData("FTC Team #", "20718");


        //for now because I am lazy I will call loop within initialization because that's a good and smart idea.
        //obviously change this. This is bad style, this is bad code. Only exists to make debugging easier.
        loop();

    }

    @Override
    public void loop() { //START - after start button is pushed
        //DriveTrain
        double forward = -gamepad1.left_stick_y;
        double right = gamepad1.left_stick_x;
        double center = 0;
        telemetry.addData("Stick X:", forward);
        telemetry.addData("Stick Y:", right);

        if (gamepad1.left_bumper) {
            center = - 1;
        } else if (gamepad1.right_bumper){
            center = 1;
        } else {
            center = 0;
        }
        telemetry.addData("Center Wheel", center);

        drive.setPowers(forward + right, forward - right, center);


        //Claw
        if (gamepad2.a){
            claw.clawOpen();
        } else if (gamepad2.b) {
            claw.clawClose();
        }

        //Slide
        //Still to implement
    }
}
