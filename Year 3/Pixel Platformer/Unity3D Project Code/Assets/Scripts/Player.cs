using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{
    private Rigidbody2D rb2D; //to have access to the Rigidbody2D component of Player 

    [SerializeField] private float movementSpeed;
    private bool facingRight; //allows to flip Player depending on the button pressed
    [SerializeField] private Transform[] groundPoints;
    [SerializeField] private float groundRadius; //collision radius
    [SerializeField] private LayerMask whatIsGround; //allows to fall through some layers
    private bool isGrounded; 
    private bool jump; 
    [SerializeField] private float jumpForce;
    [SerializeField] private bool airControl;

    public AudioClip jumpSound;

    void Start() //Start is called before the first frame update
    {
        facingRight = true;
        rb2D = GetComponent<Rigidbody2D>(); //initialisation of rb2D
    }

    // Update is called once per frame, FixedUpate keeps the frames constant regardless of your FPS
    void Update()
    {
        isGrounded = IsGrounded();
        float horizontal = Input.GetAxis("Horizontal"); //returns 0 (which is left/a, 1 which is right/d)
        //Debug.Log(horizontal);

        UserInput();
        Movement(horizontal);
        Flip(horizontal);
        ResetValues();
        
    }

    private void UserInput()
    {
        if(Input.GetKeyDown(KeyCode.UpArrow))
        {
            jump = true;
        }
    }

    private void Movement(float horizontal)
    {
        if(isGrounded || airControl)
        {
            rb2D.velocity = new Vector2(horizontal * movementSpeed, rb2D.velocity.y); //this causes rb2D to move left and right without y changing 

            if (isGrounded && jump)
            {
                isGrounded = false;
                SoundManager.instance.PlaySingle(jumpSound);
                rb2D.AddForce(new Vector2(0, jumpForce));

            }
        }  
    }

    private void Flip(float horizontal)
    {
        if(horizontal > 0 && !facingRight || horizontal < 0 && facingRight) 
        {
            facingRight = !facingRight;
            Vector3 scale = transform.localScale;
            scale.x *= -1;
            transform.localScale = scale;
        }
    }

    private bool IsGrounded()
    {
        if(rb2D.velocity.y <= 0) //if velocity.y <= 0 means you're falling
        {
            foreach(Transform point in groundPoints) //checks if groundPoint is colliding with something
            {
                Collider2D[] colliders = Physics2D.OverlapCircleAll(point.position, groundRadius, whatIsGround);

                for(int i = 0; i < colliders.Length; i++)
                {
                    if(colliders[i].gameObject != gameObject)
                    {
                        return true;
                    }
                }
            }

        }
        return false;
    }
    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.gameObject.tag == "MovingPlatform")
        {
            transform.parent = collision.transform;
            rb2D.interpolation = RigidbodyInterpolation2D.None;
        }
    }
    private void OnTriggerExit2D(Collider2D collision)
    {
        if (collision.gameObject.tag == "MovingPlatform")
        {
            transform.parent = null;
            rb2D.interpolation = RigidbodyInterpolation2D.Interpolate;
        }
    }
    private void ResetValues()
    {
        jump = false;
    }
}
