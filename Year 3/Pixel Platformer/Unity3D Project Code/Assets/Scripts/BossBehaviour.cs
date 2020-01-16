using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BossBehaviour : MonoBehaviour
{
    [SerializeField] private GameObject spike;
    private Vector2 direction;
    private Transform target;
    private bool trigger;
    private float delay = 2;
    private BoxCollider2D door;

    private void Start()
    {
        door = GameObject.FindGameObjectWithTag("Door").GetComponent<BoxCollider2D>();
        door.gameObject.SetActive(false);
        trigger = false;
    }
    void Update()
    {
        if (trigger)
        {
            delay -= Time.deltaTime;

            if(delay < 0)
            {
                target = GameObject.FindGameObjectWithTag("Player").transform;
                direction = new Vector2(target.position.x, target.position.y);

                GameObject temp = (GameObject)Instantiate(spike, transform.position, Quaternion.identity);
                temp.GetComponent<ThrowSpike>().Initialize(direction);
                delay = 2;
                Destroy(temp, 2);
            }      
        }
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if(collision.gameObject.tag == "Player")
        {
            trigger = true;
            door.gameObject.SetActive(true);
        }
    }

    private void OnTriggerExit2D(Collider2D collision)
    {
        if(collision.gameObject.tag == "Player")
        {
            trigger = false;
            door.gameObject.SetActive(false);
        }
    }
}
