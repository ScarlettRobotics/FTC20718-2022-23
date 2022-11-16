package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Core.ClawCore;
import org.firstinspires.ftc.teamcode.Core.DualMotorDrive;
import org.firstinspires.ftc.teamcode.Core.SlideCore;


/** ArcadeDrive 2 Player
 * Designed for driving to be on controller 1, upper systems on controller 2.
 * Arcade driving, similar to playing a racing game.
 */

@TeleOp(name="ArcadeDrive2P",group="auto")
public class ArcadeDrive2p extends OpMode {
    // Init classes
    DualMotorDrive drive = new DualMotorDrive();
    ClawCore claw = new ClawCore();
    SlideCore slide = new SlideCore();

    @Override
    public void init() {
        telemetry.addData("DRIVE MODE: ", "Arcade 2 Player");
        telemetry.addData("STATUS: ", "Initialized");
        telemetry.addData("FTC Team #", "20718");

    }

    @Override
    public void loop() {
        telemetry.addData("STATUS: ", "Running");
        telemetry.update();
        //DriveTrain
        double forward = -gamepad1.left_stick_y;
        double right = gamepad1.left_stick_x;
        telemetry.addData("Stick X:", forward);
        telemetry.addData("Stick Y:", right);
        drive.setPowers(forward + right, forward - right);

        // Toggle claw on A press
        if (gamepad2.a){
            claw.clawToggle();
        }

        // TODO: set slide to move up and down along specific increments instead of linearly
        // Move slide based on LT and RT press
        double slidePower = (-gamepad2.left_trigger + gamepad2.right_trigger);
        telemetry.addData("Slide Y:",slidePower);

        slide.setSlidePower(slidePower);

    }
}
