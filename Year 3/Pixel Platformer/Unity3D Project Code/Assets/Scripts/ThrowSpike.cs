using System.Collections;
using System.Collections.Generic;
using UnityEngine;


[RequireComponent(typeof(Rigidbody2D))]

public class ThrowSpike : MonoBehaviour
{
    [SerializeField] private float speed;
    private Rigidbody2D rb2D;
    private Vector2 direction;
    [SerializeField] Transform spawnPoint;
    public AudioClip deathSound;

    void Start()
    {
        rb2D = GetComponent<Rigidbody2D>();
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        rb2D.velocity = direction * speed;
    }

    public void Initialize(Vector2 direction)
    {
        this.direction = direction;
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.gameObject.tag == "Player")
        {
            SoundManager.instance.PlaySingle(deathSound);
            collision.gameObject.transform.position = spawnPoint.position;
        }
    }
}
