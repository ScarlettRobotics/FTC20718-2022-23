package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;


/** ArcadeDrive
 * Arcade driving, similar to playing a racing game.
 */

@TeleOp
public class ArcadeDrive extends OpMode {

    //Claw
    private Servo leftClaw = null;

    private Servo rightClaw = null;

    DualMotorDrive drive = new DualMotorDrive();
    ClawCore claw = new ClawCore();

    SlideCore slide = new SlideCore();

    @Override
    public void init() { //INIT - When OpMode is init but not Started
        telemetry.addData("DRIVE MODE: ", "ArcadeDrive 1 Player");
        telemetry.addData("STATUS: ", "Initialized"); // the FTC equivalent to println()
        telemetry.addData("FTC Team #", "20718");
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
        if (gamepad1.a){
            claw.clawToggle();
        }
        //Slide
        double slidePower = (-gamepad1.left_trigger + gamepad1.right_trigger);
        telemetry.addData("Slide Y:",slidePower);

        slide.setSlidePower(slidePower);

    }
}
