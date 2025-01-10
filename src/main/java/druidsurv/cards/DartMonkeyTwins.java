package druidsurv.cards;

import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.tempCards.Safety;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.cards.tempCards.Smite;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;

public class DartMonkeyTwins extends AbstractEasyCard {
    public final static String ID = makeID("DartMonkeyTwins");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public DartMonkeyTwins() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 4;
        tags.add(druidsurv.cards.cardvars.CardTags.DART);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        tags.add(druidsurv.cards.cardvars.CardTags.TWIN);
        MultiCardPreview.add(this, new DartMonkeyTwin()); // Display both Smite and Safety when you hover this card.
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmgDart(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);

        //Thunderclap's apply Vulnerable code for future reference:
        /*for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
               addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)mo, 1, false), 1, true, AbstractGameAction.AttackEffect.NONE));
            } */

        makeInHand(new DartMonkeyTwin()); // Add to the bottom of the action queue an action which adds a Shiv into your hand. (This is shorthanded by makeInHand).
    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}