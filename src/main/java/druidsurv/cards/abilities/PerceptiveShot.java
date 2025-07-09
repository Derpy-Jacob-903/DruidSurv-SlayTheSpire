package druidsurv.cards.abilities;

import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.bloons.BlueBloon;
import druidsurv.powers.monkeys.PerceptiveShotPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;


public class PerceptiveShot extends AbstractEasyCard {
    public final static String ID = makeID("PerceptiveShot");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public PerceptiveShot() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.NONE,"ArchersInstinct_CardArt");
        baseMagicNumber = magicNumber = 2;
        MultiCardPreview.add(this, new BlueBloon()); // Display both Smite and Safety when you hover this card.
        setBackgroundTexture("druidsurvResources/images/512/hero_attack.png", "druidsurvResources/images/1024/hero_attack.png");
    }


    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, new PerceptiveShotPower(p, magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
        makeInHand(new BlueBloon());
    }

    @Override
    public void upp() {
        upgradeMagicNumber(2);
    }
}