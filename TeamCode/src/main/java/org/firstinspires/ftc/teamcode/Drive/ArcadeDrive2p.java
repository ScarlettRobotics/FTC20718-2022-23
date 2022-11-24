package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;


/**
 * ArcadeDrive 2 Player
 * Designed for driving to be on controller 1, upper systems on controller 2.
 * Arcade driving, similar to playing a racing game.
 */

@TeleOp(name = "WIP ArcadeDrive2P", group = "auto")
public class ArcadeDrive2p extends OpMode {
    // Initialize classes from other files
    DualMotorDrive drive;
    ClawCore claw;
    SlideCore slide;

    // Define classes from other files
    @Override
    public void init() {
        drive = new DualMotorDrive(hardwareMap);
        claw = new ClawCore(hardwareMap);
        slide = new SlideCore(hardwareMap);
        telemetry.addData("DRIVE MODE", "Arcade 2 Player");
        telemetry.addData("STATUS", "Initialized");
        telemetry.addData("FTC Team #", "20718");
    }

    @Override
    public void loop() {
        telemetry.addData("STATUS", "Running");
        telemetry.update();

        //// DRIVETRAIN
        // Move drivetrain based on left stick movement
        double forward = -gamepad1.left_stick_y;
        double right = gamepad1.left_stick_x;
        drive.setPowers(forward + right, -1 * (forward - right) );
        // Debug info
        telemetry.addData("Stick X:", forward);
        telemetry.addData("Stick Y:", right);

        //// CLAW
        // Open/close claw if A/B is pressed (respectively)
        if (gamepad2.a){
            claw.clawOpen();
        } else if (gamepad2.b) {
            claw.clawClose();
        }
        claw.telemetry(telemetry);

        //// SLIDE
        // Move slide based on LT/RT presses
        double slidePower = (-gamepad2.left_trigger + gamepad2.right_trigger);
        slide.setSlidePower(slidePower);
        // Debug info
        telemetry.addData("Slide Y:",slidePower);

    }
}
