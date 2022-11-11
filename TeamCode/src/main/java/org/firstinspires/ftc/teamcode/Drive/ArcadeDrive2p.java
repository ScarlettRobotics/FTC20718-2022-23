package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;


/** ArcadeDrive 2 Player
 * Designed for driving to be on controller 1, upper systems on controller 2.
 * Arcade driving, similar to playing a racing game.
 */

@TeleOp
public class ArcadeDrive2p extends OpMode {

    //Claw
    private Servo leftClaw = null;

    private Servo rightClaw = null;

    DualMotorDrive drive = new DualMotorDrive();
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

        telemetry.addData("Stick X:", forward);
        telemetry.addData("Stick Y:", right);


        drive.setPowers(forward + right, forward - right);


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
