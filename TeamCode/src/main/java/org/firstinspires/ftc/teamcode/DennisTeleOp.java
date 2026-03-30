package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Not Dennis Teleop")
public class DennisTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor motor;
        motor = hardwareMap.get(DcMotor.class, "motor");

        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.circle) {
                motor.setPower(1);
            } else {
                motor.setPower(0);
            }

            double MRpowers = deadzone(gamepad1.right_trigger);
            motor.setPower(MRpowers);

            double joystickPower = deadzone(gamepad1.left_stick_x);
            motor.setPower(joystickPower);

            telemetry.addData("Motor Power", motor.getPower());
        }
    }

    public static double deadzone(double input) {
        if (Math.abs(input) > 0.1) {
            return input;
        } else {
            return 0;
        }
    }
}
