import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends Screen implements ActionListener {

    public JLabel usernameLabel;
    public JTextField usernameTextField;
    public JLabel passwordLabel;
    public JPasswordField passwordField;
    public JButton loginButton;
    public JLabel errorLabel;

    public GridBagConstraints usernameLabelConstraints;
    public GridBagConstraints usernameTextFieldConstraints;
    public GridBagConstraints passwordLabelConstraints;
    public GridBagConstraints passwordFieldConstraints;
    public GridBagConstraints loginButtonConstraints;
    public GridBagConstraints errorLabelConstraints;

    public LoginScreen(JPanel container) {
        super(new GridBagLayout());
        container.add(this, Screen.LOGIN);
        this.attachComponents();
    }

    @Override
    protected void createComponents() {
        this.usernameLabel = new JLabel("Username");
        this.usernameTextField = new JTextField(20);
        this.passwordLabel = new JLabel("Password");
        this.passwordField = new JPasswordField(20);
        this.loginButton = new JButton("Login");
        this.errorLabel = new JLabel("");
        this.errorLabel.setForeground(Color.red);
    }

    @Override
    protected void attachComponents() {
        this.add(this.usernameLabel, this.usernameLabelConstraints);
        this.add(this.usernameTextField, this.usernameTextFieldConstraints);
        this.add(this.passwordLabel, this.passwordLabelConstraints);
        this.add(this.passwordField, this.passwordFieldConstraints);
        this.add(this.loginButton, this.loginButtonConstraints);
        this.add(this.errorLabel, this.errorLabelConstraints);
    }

    @Override
    protected void setupConstraints() {
        this.usernameLabelConstraints = new GridBagConstraints();
        this.usernameLabelConstraints.gridx = 0;
        this.usernameLabelConstraints.gridy = 0;
        this.usernameLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.usernameLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.usernameTextFieldConstraints = new GridBagConstraints();
        this.usernameTextFieldConstraints.gridx = 0;
        this.usernameTextFieldConstraints.gridy = 1;
        this.usernameTextFieldConstraints.insets = new Insets(0, 0, 8, 0);
        this.usernameTextFieldConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.passwordLabelConstraints = new GridBagConstraints();
        this.passwordLabelConstraints.gridx = 0;
        this.passwordLabelConstraints.gridy = 2;
        this.passwordLabelConstraints.insets = new Insets(0, 0, 8, 0);
        this.passwordLabelConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.passwordFieldConstraints = new GridBagConstraints();
        this.passwordFieldConstraints.gridx = 0;
        this.passwordFieldConstraints.gridy = 3;
        this.passwordFieldConstraints.insets = new Insets(0, 0, 8, 0);
        this.passwordFieldConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.loginButtonConstraints = new GridBagConstraints();
        this.loginButtonConstraints.gridx = 0;
        this.loginButtonConstraints.gridy = 4;
        this.loginButtonConstraints.insets = new Insets(0, 0, 8, 0);
        this.loginButtonConstraints.fill = GridBagConstraints.HORIZONTAL;

        this.errorLabelConstraints = new GridBagConstraints();
        this.errorLabelConstraints.gridx = 0;
        this.errorLabelConstraints.gridy = 5;
        this.errorLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
    }

    @Override
    protected void attachListeners() {
        this.loginButton.addActionListener(this);
    }

    /**
     * Abstract method that children must implements as different screens have different Swing component requirements.
     * Therefore setting dimensions will be different
     */
    @Override
    protected void setDimensions() {
        this.usernameLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.usernameTextField.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.passwordLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.passwordField.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.loginButton.setPreferredSize(Screen.DEFAULT_DIMENSION);
        this.errorLabel.setPreferredSize(Screen.DEFAULT_DIMENSION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = this.usernameTextField.getText();
        String password = String.valueOf(this.passwordField.getPassword());

        if (username.equals("DrWeiLai") && password.equals("WillGiveMe100%"))
        {
            this.goTo(Screen.SETUP);
        } else {
            this.errorLabel.setText("Incorrect username or password. Please try again.");
        }
    }
}
